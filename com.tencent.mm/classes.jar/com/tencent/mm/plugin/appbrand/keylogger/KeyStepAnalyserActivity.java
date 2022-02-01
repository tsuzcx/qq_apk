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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class KeyStepAnalyserActivity
  extends KeyStepBaseActivity
{
  private a lGK;
  private Pattern lGL;
  private Class lGM;
  private int mDay;
  private int mMonth;
  private String mProcessName;
  private int mYear;
  
  private void te(long paramLong)
  {
    AppMethodBeat.i(201212);
    ae.i("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.lGK.a(this.mProcessName, this.lGL, paramLong, new IKeyStepAnalyser.a()
    {
      public final void bz(final List<IKeyStepAnalyser.b> paramAnonymousList)
      {
        AppMethodBeat.i(201202);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(201201);
            KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this, paramAnonymousList);
            AppMethodBeat.o(201201);
          }
        });
        AppMethodBeat.o(201202);
      }
    });
    AppMethodBeat.o(201212);
  }
  
  protected final int getLayoutId()
  {
    return 2131496130;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201211);
    super.onCreate(paramBundle);
    this.lGM = ((Class)getIntent().getSerializableExtra("proces"));
    this.mProcessName = f.ay(this.lGM);
    this.lGL = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    setTitle(getString(2131765443));
    paramBundle = Calendar.getInstance();
    this.mYear = paramBundle.get(1);
    this.mMonth = paramBundle.get(2);
    this.mDay = paramBundle.get(5);
    findViewById(2131307181).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(201200);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        KeyStepAnalyserActivity.a(KeyStepAnalyserActivity.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyserActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201200);
      }
    });
    this.lGK = new a();
    te(System.currentTimeMillis());
    AppMethodBeat.o(201211);
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
    List<IKeyStepAnalyser.b> lGR;
    private final LayoutInflater mInflater;
    
    static
    {
      AppMethodBeat.i(201210);
      sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      AppMethodBeat.o(201210);
    }
    
    a(Context paramContext)
    {
      AppMethodBeat.i(201205);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(201205);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(201206);
      if (this.lGR == null)
      {
        AppMethodBeat.o(201206);
        return 0;
      }
      int i = this.lGR.size();
      AppMethodBeat.o(201206);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(201208);
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(2131496159, paramViewGroup, false);
        paramViewGroup = new KeyStepAnalyserActivity.b();
        paramViewGroup.iXP = ((TextView)localView.findViewById(2131298928));
        localView.setTag(paramViewGroup);
        if (ue(paramInt).lHF.isEmpty()) {
          break label133;
        }
        paramView = (IKeyStepAnalyser.StepLogInfo)ue(paramInt).lHF.get(0);
        if (paramView != null) {
          break label116;
        }
        paramView = null;
      }
      for (;;)
      {
        paramViewGroup.iXP.setText(paramView);
        AppMethodBeat.o(201208);
        return localView;
        paramViewGroup = (KeyStepAnalyserActivity.b)paramView.getTag();
        localView = paramView;
        break;
        label116:
        paramView = sDateFormat.format(Long.valueOf(paramView.time));
        continue;
        label133:
        paramViewGroup.iXP.setText(null);
        paramView = null;
      }
    }
    
    public final IKeyStepAnalyser.b ue(int paramInt)
    {
      AppMethodBeat.i(201207);
      IKeyStepAnalyser.b localb = (IKeyStepAnalyser.b)this.lGR.get(paramInt);
      AppMethodBeat.o(201207);
      return localb;
    }
  }
  
  static final class b
  {
    public TextView iXP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */