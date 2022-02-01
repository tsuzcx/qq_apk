package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import com.tencent.luggage.a.e;
import com.tencent.luggage.a.f;
import com.tencent.luggage.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class KeyStepAnalyserActivity
  extends KeyStepBaseActivity
{
  private int mDay;
  private int mMonth;
  private String mProcessName;
  private int mYear;
  private a pPs;
  private Pattern pPt;
  private Class pPu;
  private String pPv;
  
  private void Hx(long paramLong)
  {
    AppMethodBeat.i(207805);
    Log.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.pPs.a(this.mProcessName, this.pPt, paramLong, new IKeyStepAnalyser.a()
    {
      public final void bL(final List<IKeyStepAnalyser.b> paramAnonymousList)
      {
        AppMethodBeat.i(210117);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208419);
            KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, paramAnonymousList);
            AppMethodBeat.o(208419);
          }
        });
        AppMethodBeat.o(210117);
      }
    });
    AppMethodBeat.o(207805);
  }
  
  protected final int getLayoutId()
  {
    return a.f.activity_key_step_analyser;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(207801);
    super.onCreate(paramBundle);
    this.pPu = ((Class)getIntent().getSerializableExtra("process"));
    this.pPv = getIntent().getStringExtra("category");
    this.mProcessName = f.aB(this.pPu);
    this.pPt = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    setTitle(getString(a.g.key_step_logger_analyser_list_title));
    paramBundle = Calendar.getInstance();
    this.mYear = paramBundle.get(1);
    this.mMonth = paramBundle.get(2);
    this.mDay = paramBundle.get(5);
    findViewById(a.e.date_picker_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210582);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210582);
      }
    });
    this.pPs = new a();
    Hx(System.currentTimeMillis());
    AppMethodBeat.o(207801);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private static SimpleDateFormat sDateFormat;
    private final LayoutInflater mInflater;
    List<IKeyStepAnalyser.b> pPA;
    
    static
    {
      AppMethodBeat.i(208683);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      AppMethodBeat.o(208683);
    }
    
    a(Context paramContext)
    {
      AppMethodBeat.i(208676);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(208676);
    }
    
    public final IKeyStepAnalyser.b BD(int paramInt)
    {
      AppMethodBeat.i(208680);
      IKeyStepAnalyser.b localb = (IKeyStepAnalyser.b)this.pPA.get(paramInt);
      AppMethodBeat.o(208680);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(208677);
      if (this.pPA == null)
      {
        AppMethodBeat.o(208677);
        return 0;
      }
      int i = this.pPA.size();
      AppMethodBeat.o(208677);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(208681);
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(a.f.view_process_item, paramViewGroup, false);
        paramViewGroup = new KeyStepAnalyserActivity.b();
        paramViewGroup.mMb = ((TextView)localView.findViewById(a.e.date));
        localView.setTag(paramViewGroup);
        if (BD(paramInt).pQn.isEmpty()) {
          break label135;
        }
        paramView = (IKeyStepAnalyser.StepLogInfo)BD(paramInt).pQn.get(0);
        if (paramView != null) {
          break label118;
        }
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.mMb.setText(paramView);
        AppMethodBeat.o(208681);
        return localView;
        paramViewGroup = (KeyStepAnalyserActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label118:
        paramView = sDateFormat.format(Long.valueOf(paramView.time));
        continue;
        label135:
        paramViewGroup.mMb.setText(null);
        paramView = null;
      }
    }
  }
  
  static final class b
  {
    public TextView mMb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */