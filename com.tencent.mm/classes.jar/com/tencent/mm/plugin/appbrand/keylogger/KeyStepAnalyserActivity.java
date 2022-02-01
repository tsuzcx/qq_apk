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
  private a kDU;
  private Pattern kDV;
  private Class kDW;
  private int mDay;
  private int mMonth;
  private String mProcessName;
  private int mYear;
  
  private void ng(long paramLong)
  {
    AppMethodBeat.i(194818);
    ad.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.kDU.a(this.mProcessName, this.kDV, paramLong, new IKeyStepAnalyser.a()
    {
      public final void ac(final List<IKeyStepAnalyser.b> paramAnonymousList)
      {
        AppMethodBeat.i(194808);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194807);
            KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, paramAnonymousList);
            AppMethodBeat.o(194807);
          }
        });
        AppMethodBeat.o(194808);
      }
    });
    AppMethodBeat.o(194818);
  }
  
  protected final int getLayoutId()
  {
    return 2131496130;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194817);
    super.onCreate(paramBundle);
    this.kDW = ((Class)getIntent().getSerializableExtra("proces"));
    this.mProcessName = f.ay(this.kDW);
    this.kDV = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    setTitle(getString(2131765443));
    paramBundle = Calendar.getInstance();
    this.mYear = paramBundle.get(1);
    this.mMonth = paramBundle.get(2);
    this.mDay = paramBundle.get(5);
    findViewById(2131307181).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194806);
        KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this);
        AppMethodBeat.o(194806);
      }
    });
    this.kDU = new a();
    ng(System.currentTimeMillis());
    AppMethodBeat.o(194817);
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
    List<IKeyStepAnalyser.b> kEb;
    private final LayoutInflater mInflater;
    
    static
    {
      AppMethodBeat.i(194816);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      AppMethodBeat.o(194816);
    }
    
    a(Context paramContext)
    {
      AppMethodBeat.i(194811);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(194811);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(194812);
      if (this.kEb == null)
      {
        AppMethodBeat.o(194812);
        return 0;
      }
      int i = this.kEb.size();
      AppMethodBeat.o(194812);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(194814);
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(2131496159, paramViewGroup, false);
        paramViewGroup = new KeyStepAnalyserActivity.b();
        paramViewGroup.ibF = ((TextView)localView.findViewById(2131298928));
        localView.setTag(paramViewGroup);
        if (sE(paramInt).kEP.isEmpty()) {
          break label133;
        }
        paramView = (IKeyStepAnalyser.StepLogInfo)sE(paramInt).kEP.get(0);
        if (paramView != null) {
          break label116;
        }
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.ibF.setText(paramView);
        AppMethodBeat.o(194814);
        return localView;
        paramViewGroup = (KeyStepAnalyserActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label116:
        paramView = sDateFormat.format(Long.valueOf(paramView.time));
        continue;
        label133:
        paramViewGroup.ibF.setText(null);
        paramView = null;
      }
    }
    
    public final IKeyStepAnalyser.b sE(int paramInt)
    {
      AppMethodBeat.i(194813);
      IKeyStepAnalyser.b localb = (IKeyStepAnalyser.b)this.kEb.get(paramInt);
      AppMethodBeat.o(194813);
      return localb;
    }
  }
  
  static final class b
  {
    public TextView ibF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */