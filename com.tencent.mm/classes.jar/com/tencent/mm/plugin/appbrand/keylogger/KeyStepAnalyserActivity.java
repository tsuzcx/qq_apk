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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class KeyStepAnalyserActivity
  extends KeyStepBaseActivity
{
  private a lfn;
  private Pattern lfo;
  private Class lfp;
  private int mDay;
  private int mMonth;
  private String mProcessName;
  private int mYear;
  
  private void qS(long paramLong)
  {
    AppMethodBeat.i(200973);
    ac.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.lfn.a(this.mProcessName, this.lfo, paramLong, new IKeyStepAnalyser.a()
    {
      public final void bv(final List<IKeyStepAnalyser.b> paramAnonymousList)
      {
        AppMethodBeat.i(200963);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200962);
            KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, paramAnonymousList);
            AppMethodBeat.o(200962);
          }
        });
        AppMethodBeat.o(200963);
      }
    });
    AppMethodBeat.o(200973);
  }
  
  protected final int getLayoutId()
  {
    return 2131496130;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200972);
    super.onCreate(paramBundle);
    this.lfp = ((Class)getIntent().getSerializableExtra("proces"));
    this.mProcessName = f.ay(this.lfp);
    this.lfo = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    setTitle(getString(2131765443));
    paramBundle = Calendar.getInstance();
    this.mYear = paramBundle.get(1);
    this.mMonth = paramBundle.get(2);
    this.mDay = paramBundle.get(5);
    findViewById(2131307181).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200961);
        KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this);
        AppMethodBeat.o(200961);
      }
    });
    this.lfn = new a();
    qS(System.currentTimeMillis());
    AppMethodBeat.o(200972);
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
    List<IKeyStepAnalyser.b> lfu;
    private final LayoutInflater mInflater;
    
    static
    {
      AppMethodBeat.i(200971);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      AppMethodBeat.o(200971);
    }
    
    a(Context paramContext)
    {
      AppMethodBeat.i(200966);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(200966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(200967);
      if (this.lfu == null)
      {
        AppMethodBeat.o(200967);
        return 0;
      }
      int i = this.lfu.size();
      AppMethodBeat.o(200967);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(200969);
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(2131496159, paramViewGroup, false);
        paramViewGroup = new KeyStepAnalyserActivity.b();
        paramViewGroup.iBM = ((TextView)localView.findViewById(2131298928));
        localView.setTag(paramViewGroup);
        if (tv(paramInt).lgi.isEmpty()) {
          break label133;
        }
        paramView = (IKeyStepAnalyser.StepLogInfo)tv(paramInt).lgi.get(0);
        if (paramView != null) {
          break label116;
        }
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.iBM.setText(paramView);
        AppMethodBeat.o(200969);
        return localView;
        paramViewGroup = (KeyStepAnalyserActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label116:
        paramView = sDateFormat.format(Long.valueOf(paramView.time));
        continue;
        label133:
        paramViewGroup.iBM.setText(null);
        paramView = null;
      }
    }
    
    public final IKeyStepAnalyser.b tv(int paramInt)
    {
      AppMethodBeat.i(200968);
      IKeyStepAnalyser.b localb = (IKeyStepAnalyser.b)this.lfu.get(paramInt);
      AppMethodBeat.o(200968);
      return localb;
    }
  }
  
  static final class b
  {
    public TextView iBM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */