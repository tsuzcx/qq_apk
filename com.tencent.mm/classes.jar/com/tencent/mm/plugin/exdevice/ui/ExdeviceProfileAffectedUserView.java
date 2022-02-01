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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.model.f.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView
  extends LinearLayout
{
  private String lEN;
  private TextView qkZ;
  private MMHorList qla;
  private a qlb;
  private ArrayList<String> qlc;
  
  public ExdeviceProfileAffectedUserView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24088);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493873, this, true);
    this.qkZ = ((TextView)paramAttributeSet.findViewById(2131303446));
    this.qla = ((MMHorList)paramAttributeSet.findViewById(2131303445));
    this.qla.setCenterInParent(true);
    int i = com.tencent.mm.cc.a.fromDPToPix(paramContext, 44);
    this.qla.setOverScrollEnabled(true);
    this.qla.setItemWidth(i);
    this.qla.setCenterInParent(true);
    this.qlb = new a((byte)0);
    this.qla.setAdapter(this.qlb);
    this.qla.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(24079);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousView = (String)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        ad.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", new Object[] { paramAnonymousView });
        if (bt.isNullOrNil(paramAnonymousView))
        {
          ad.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(24079);
          return;
        }
        paramAnonymousAdapterView = new Intent(paramContext, ExdeviceProfileUI.class);
        paramAnonymousAdapterView.putExtra("username", paramAnonymousView);
        paramAnonymousView = paramContext;
        paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(24079);
      }
    });
    this.qkZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24080);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = u.aAm();
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
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.qlc = paramArrayList;
    if ((this.qlc == null) || (this.qlc.size() == 0))
    {
      this.qkZ.setText("");
      setVisibility(8);
      AppMethodBeat.o(24089);
      return;
    }
    setVisibility(0);
    this.qkZ.setText(getResources().getString(2131758572, new Object[] { Integer.valueOf(this.qlc.size()) }));
    this.qlb.notifyDataSetChanged();
    AppMethodBeat.o(24089);
  }
  
  public void setUsername(String paramString)
  {
    this.lEN = paramString;
  }
  
  final class a
    extends BaseAdapter
  {
    private Runnable qle;
    
    private a()
    {
      AppMethodBeat.i(24083);
      this.qle = new Runnable()
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
        paramView = LayoutInflater.from(ExdeviceProfileAffectedUserView.this.getContext()).inflate(2131493879, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.jdF = ((ImageView)paramView.findViewById(2131296996));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Runnable localRunnable = this.qle;
        Object localObject = p.aEx();
        if (localObject != null)
        {
          localObject = ((j)localObject).Dj(str);
          if ((localObject == null) || (bt.isNullOrNil(((i)localObject).aEr())))
          {
            long l = bt.flT();
            as.a.hFO.a(str, "", new f.1(l, localRunnable));
          }
        }
        a.b.v(paramViewGroup.jdF, str);
        AppMethodBeat.o(24086);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    final class a
    {
      ImageView jdF;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView
 * JD-Core Version:    0.7.0.1
 */