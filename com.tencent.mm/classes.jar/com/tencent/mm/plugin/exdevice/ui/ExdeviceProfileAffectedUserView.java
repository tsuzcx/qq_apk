package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.model.f.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView
  extends LinearLayout
{
  private String pRV;
  private TextView vot;
  private MMHorList vou;
  private a vov;
  private ArrayList<String> vow;
  
  public ExdeviceProfileAffectedUserView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24088);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.egA, this, true);
    this.vot = ((TextView)paramAttributeSet.findViewById(R.h.dRq));
    this.vou = ((MMHorList)paramAttributeSet.findViewById(R.h.dRp));
    this.vou.setCenterInParent(true);
    int i = com.tencent.mm.ci.a.fromDPToPix(paramContext, 44);
    this.vou.setOverScrollEnabled(true);
    this.vou.setItemWidth(i);
    this.vou.setCenterInParent(true);
    this.vov = new a((byte)0);
    this.vou.setAdapter(this.vov);
    this.vou.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(24079);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousView = (String)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        Log.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", new Object[] { paramAnonymousView });
        if (Util.isNullOrNil(paramAnonymousView))
        {
          Log.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(24079);
          return;
        }
        paramAnonymousAdapterView = new Intent(paramContext, ExdeviceProfileUI.class);
        paramAnonymousAdapterView.putExtra("username", paramAnonymousView);
        paramAnonymousView = paramContext;
        paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aFh(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(24079);
      }
    });
    this.vot.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24080);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = z.bcZ();
        if ((paramAnonymousView != null) && (paramAnonymousView.equals(ExdeviceProfileAffectedUserView.a(ExdeviceProfileAffectedUserView.this))))
        {
          paramAnonymousView = ExdeviceProfileAffectedUserView.b(ExdeviceProfileAffectedUserView.this);
          if (ExdeviceProfileAffectedUserView.b(ExdeviceProfileAffectedUserView.this).getVisibility() != 0) {
            break label105;
          }
        }
        label105:
        for (int i = 8;; i = 0)
        {
          paramAnonymousView.setVisibility(i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24080);
          return;
        }
      }
    });
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24081);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ExdeviceProfileAffectedUserView.c(ExdeviceProfileAffectedUserView.this).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24081);
      }
    });
    setVisibility(8);
    AppMethodBeat.o(24088);
  }
  
  public void setAffectedUserInfo(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(24089);
    this.vow = paramArrayList;
    if ((this.vow == null) || (this.vow.size() == 0))
    {
      this.vot.setText("");
      setVisibility(8);
      AppMethodBeat.o(24089);
      return;
    }
    setVisibility(0);
    this.vot.setText(getResources().getString(R.l.eDO, new Object[] { Integer.valueOf(this.vow.size()) }));
    this.vov.notifyDataSetChanged();
    AppMethodBeat.o(24089);
  }
  
  public void setUsername(String paramString)
  {
    this.pRV = paramString;
  }
  
  final class a
    extends BaseAdapter
  {
    private Runnable voy;
    
    private a()
    {
      AppMethodBeat.i(24083);
      this.voy = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24082);
          ExdeviceProfileAffectedUserView.a.this.notifyDataSetChanged();
          AppMethodBeat.o(24082);
        }
      };
      AppMethodBeat.o(24083);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(24085);
      String str = (String)ExdeviceProfileAffectedUserView.d(ExdeviceProfileAffectedUserView.this).get(paramInt);
      AppMethodBeat.o(24085);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(24084);
      if (ExdeviceProfileAffectedUserView.d(ExdeviceProfileAffectedUserView.this) == null)
      {
        AppMethodBeat.o(24084);
        return 0;
      }
      int i = ExdeviceProfileAffectedUserView.d(ExdeviceProfileAffectedUserView.this).size();
      AppMethodBeat.o(24084);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(24086);
      String str = getItem(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(ExdeviceProfileAffectedUserView.this.getContext()).inflate(R.i.egF, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.mWb = ((ImageView)paramView.findViewById(R.h.avatar));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Runnable localRunnable = this.voy;
        Object localObject = q.bhP();
        if (localObject != null)
        {
          localObject = ((k)localObject).TS(str);
          if ((localObject == null) || (Util.isNullOrNil(((j)localObject).bhI())))
          {
            long l = Util.nowMilliSecond();
            az.a.ltq.a(str, "", new f.1(l, localRunnable));
          }
        }
        a.b.B(paramViewGroup.mWb, str);
        AppMethodBeat.o(24086);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    final class a
    {
      ImageView mWb;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView
 * JD-Core Version:    0.7.0.1
 */