package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import com.tencent.luggage.a.e;
import com.tencent.luggage.a.f;
import com.tencent.luggage.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private a sTS;
  private Pattern sTT;
  private Class sTU;
  private String sTV;
  
  private void jN(long paramLong)
  {
    AppMethodBeat.i(319462);
    Log.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.sTS.a(this.mProcessName, this.sTT, paramLong, new IKeyStepAnalyser.a()
    {
      public final void dw(final List<IKeyStepAnalyser.b> paramAnonymousList)
      {
        AppMethodBeat.i(319444);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(319450);
            KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, paramAnonymousList);
            AppMethodBeat.o(319450);
          }
        });
        AppMethodBeat.o(319444);
      }
    });
    AppMethodBeat.o(319462);
  }
  
  protected final int getLayoutId()
  {
    return a.f.activity_key_step_analyser;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(319553);
    super.onCreate(paramBundle);
    this.sTU = ((Class)getIntent().getSerializableExtra("process"));
    this.sTV = getIntent().getStringExtra("category");
    this.mProcessName = f.aV(this.sTU);
    this.sTT = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    setTitle(getString(a.g.key_step_logger_analyser_list_title));
    paramBundle = Calendar.getInstance();
    this.mYear = paramBundle.get(1);
    this.mMonth = paramBundle.get(2);
    this.mDay = paramBundle.get(5);
    findViewById(a.e.date_picker_btn).setOnClickListener(new KeyStepAnalyserActivity.1(this));
    this.sTS = new a();
    jN(System.currentTimeMillis());
    AppMethodBeat.o(319553);
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
    List<IKeyStepAnalyser.b> sUa;
    
    static
    {
      AppMethodBeat.i(319477);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      AppMethodBeat.o(319477);
    }
    
    a(Context paramContext)
    {
      AppMethodBeat.i(319470);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(319470);
    }
    
    public final IKeyStepAnalyser.b BR(int paramInt)
    {
      AppMethodBeat.i(319491);
      IKeyStepAnalyser.b localb = (IKeyStepAnalyser.b)this.sUa.get(paramInt);
      AppMethodBeat.o(319491);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(319482);
      if (this.sUa == null)
      {
        AppMethodBeat.o(319482);
        return 0;
      }
      int i = this.sUa.size();
      AppMethodBeat.o(319482);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(319506);
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(a.f.view_process_item, paramViewGroup, false);
        paramViewGroup = new KeyStepAnalyserActivity.b();
        paramViewGroup.pIJ = ((TextView)localView.findViewById(a.e.date));
        localView.setTag(paramViewGroup);
        if (BR(paramInt).sUN.isEmpty()) {
          break label135;
        }
        paramView = (IKeyStepAnalyser.StepLogInfo)BR(paramInt).sUN.get(0);
        if (paramView != null) {
          break label118;
        }
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.pIJ.setText(paramView);
        AppMethodBeat.o(319506);
        return localView;
        paramViewGroup = (KeyStepAnalyserActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label118:
        paramView = sDateFormat.format(Long.valueOf(paramView.time));
        continue;
        label135:
        paramViewGroup.pIJ.setText(null);
        paramView = null;
      }
    }
  }
  
  static final class b
  {
    public TextView pIJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */