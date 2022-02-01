package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
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
  private Pattern mOA;
  private Class mOB;
  private String mOC;
  private a mOz;
  private String mProcessName;
  private int mYear;
  
  private void Bj(long paramLong)
  {
    AppMethodBeat.i(221256);
    Log.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.mOz.a(this.mProcessName, this.mOA, paramLong, new IKeyStepAnalyser.a()
    {
      public final void bM(final List<IKeyStepAnalyser.b> paramAnonymousList)
      {
        AppMethodBeat.i(221246);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221245);
            KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, paramAnonymousList);
            AppMethodBeat.o(221245);
          }
        });
        AppMethodBeat.o(221246);
      }
    });
    AppMethodBeat.o(221256);
  }
  
  protected final int getLayoutId()
  {
    return 2131492957;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221255);
    super.onCreate(paramBundle);
    this.mOB = ((Class)getIntent().getSerializableExtra("process"));
    this.mOC = getIntent().getStringExtra("category");
    this.mProcessName = f.aC(this.mOB);
    this.mOA = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    setTitle(getString(2131762047));
    paramBundle = Calendar.getInstance();
    this.mYear = paramBundle.get(1);
    this.mMonth = paramBundle.get(2);
    this.mDay = paramBundle.get(5);
    findViewById(2131299416).setOnClickListener(new KeyStepAnalyserActivity.1(this));
    this.mOz = new a();
    Bj(System.currentTimeMillis());
    AppMethodBeat.o(221255);
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
    List<IKeyStepAnalyser.b> mOH;
    
    static
    {
      AppMethodBeat.i(221254);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      AppMethodBeat.o(221254);
    }
    
    a(Context paramContext)
    {
      AppMethodBeat.i(221249);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(221249);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(221250);
      if (this.mOH == null)
      {
        AppMethodBeat.o(221250);
        return 0;
      }
      int i = this.mOH.size();
      AppMethodBeat.o(221250);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(221252);
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(2131496819, paramViewGroup, false);
        paramViewGroup = new KeyStepAnalyserActivity.b();
        paramViewGroup.jUO = ((TextView)localView.findViewById(2131299412));
        localView.setTag(paramViewGroup);
        if (yd(paramInt).mPu.isEmpty()) {
          break label133;
        }
        paramView = (IKeyStepAnalyser.StepLogInfo)yd(paramInt).mPu.get(0);
        if (paramView != null) {
          break label116;
        }
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.jUO.setText(paramView);
        AppMethodBeat.o(221252);
        return localView;
        paramViewGroup = (KeyStepAnalyserActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label116:
        paramView = sDateFormat.format(Long.valueOf(paramView.time));
        continue;
        label133:
        paramViewGroup.jUO.setText(null);
        paramView = null;
      }
    }
    
    public final IKeyStepAnalyser.b yd(int paramInt)
    {
      AppMethodBeat.i(221251);
      IKeyStepAnalyser.b localb = (IKeyStepAnalyser.b)this.mOH.get(paramInt);
      AppMethodBeat.o(221251);
      return localb;
    }
  }
  
  static final class b
  {
    public TextView jUO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */