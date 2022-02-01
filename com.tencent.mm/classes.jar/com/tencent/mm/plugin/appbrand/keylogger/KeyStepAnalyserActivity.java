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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class KeyStepAnalyserActivity
  extends KeyStepBaseActivity
{
  private a lCl;
  private Pattern lCm;
  private Class lCn;
  private int mDay;
  private int mMonth;
  private String mProcessName;
  private int mYear;
  
  private void sR(long paramLong)
  {
    AppMethodBeat.i(187645);
    ad.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.lCl.a(this.mProcessName, this.lCm, paramLong, new IKeyStepAnalyser.a()
    {
      public final void bx(final List<IKeyStepAnalyser.b> paramAnonymousList)
      {
        AppMethodBeat.i(187635);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187634);
            KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, paramAnonymousList);
            AppMethodBeat.o(187634);
          }
        });
        AppMethodBeat.o(187635);
      }
    });
    AppMethodBeat.o(187645);
  }
  
  protected final int getLayoutId()
  {
    return 2131496130;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187644);
    super.onCreate(paramBundle);
    this.lCn = ((Class)getIntent().getSerializableExtra("proces"));
    this.mProcessName = f.ay(this.lCn);
    this.lCm = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    setTitle(getString(2131765443));
    paramBundle = Calendar.getInstance();
    this.mYear = paramBundle.get(1);
    this.mMonth = paramBundle.get(2);
    this.mDay = paramBundle.get(5);
    findViewById(2131307181).setOnClickListener(new KeyStepAnalyserActivity.1(this));
    this.lCl = new a();
    sR(System.currentTimeMillis());
    AppMethodBeat.o(187644);
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
    List<IKeyStepAnalyser.b> lCs;
    private final LayoutInflater mInflater;
    
    static
    {
      AppMethodBeat.i(187643);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      AppMethodBeat.o(187643);
    }
    
    a(Context paramContext)
    {
      AppMethodBeat.i(187638);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(187638);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(187639);
      if (this.lCs == null)
      {
        AppMethodBeat.o(187639);
        return 0;
      }
      int i = this.lCs.size();
      AppMethodBeat.o(187639);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(187641);
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(2131496159, paramViewGroup, false);
        paramViewGroup = new KeyStepAnalyserActivity.b();
        paramViewGroup.iUW = ((TextView)localView.findViewById(2131298928));
        localView.setTag(paramViewGroup);
        if (tY(paramInt).lDg.isEmpty()) {
          break label133;
        }
        paramView = (IKeyStepAnalyser.StepLogInfo)tY(paramInt).lDg.get(0);
        if (paramView != null) {
          break label116;
        }
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.iUW.setText(paramView);
        AppMethodBeat.o(187641);
        return localView;
        paramViewGroup = (KeyStepAnalyserActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label116:
        paramView = sDateFormat.format(Long.valueOf(paramView.time));
        continue;
        label133:
        paramViewGroup.iUW.setText(null);
        paramView = null;
      }
    }
    
    public final IKeyStepAnalyser.b tY(int paramInt)
    {
      AppMethodBeat.i(187640);
      IKeyStepAnalyser.b localb = (IKeyStepAnalyser.b)this.lCs.get(paramInt);
      AppMethodBeat.o(187640);
      return localb;
    }
  }
  
  static final class b
  {
    public TextView iUW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */