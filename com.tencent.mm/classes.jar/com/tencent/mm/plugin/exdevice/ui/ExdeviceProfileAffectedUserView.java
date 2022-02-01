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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.exdevice.model.h.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView
  extends LinearLayout
{
  private String sWX;
  private TextView yAP;
  private MMHorList yAQ;
  private a yAR;
  private ArrayList<String> yAS;
  
  public ExdeviceProfileAffectedUserView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24088);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.i.gju, this, true);
    this.yAP = ((TextView)paramAttributeSet.findViewById(R.h.fTs));
    this.yAQ = ((MMHorList)paramAttributeSet.findViewById(R.h.fTr));
    this.yAQ.setCenterInParent(true);
    int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 44);
    this.yAQ.setOverScrollEnabled(true);
    this.yAQ.setItemWidth(i);
    this.yAQ.setCenterInParent(true);
    this.yAR = new a((byte)0);
    this.yAQ.setAdapter(this.yAR);
    this.yAQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(24079);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
        paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(24079);
      }
    });
    this.yAP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24080);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = z.bAM();
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
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceProfileAffectedUserView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.yAS = paramArrayList;
    if ((this.yAS == null) || (this.yAS.size() == 0))
    {
      this.yAP.setText("");
      setVisibility(8);
      AppMethodBeat.o(24089);
      return;
    }
    setVisibility(0);
    this.yAP.setText(getResources().getString(R.l.gGC, new Object[] { Integer.valueOf(this.yAS.size()) }));
    this.yAR.notifyDataSetChanged();
    AppMethodBeat.o(24089);
  }
  
  public void setUsername(String paramString)
  {
    this.sWX = paramString;
  }
  
  final class a
    extends BaseAdapter
  {
    private Runnable yAU;
    
    private a()
    {
      AppMethodBeat.i(24083);
      this.yAU = new Runnable()
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
        paramView = LayoutInflater.from(ExdeviceProfileAffectedUserView.this.getContext()).inflate(R.i.gjB, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.avatar = ((ImageView)paramView.findViewById(R.h.avatar));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Runnable localRunnable = this.yAU;
        Object localObject = q.bFE();
        if (localObject != null)
        {
          localObject = ((k)localObject).LS(str);
          if ((localObject == null) || (Util.isNullOrNil(((j)localObject).bFx())))
          {
            long l = Util.nowMilliSecond();
            az.a.okP.a(str, "", new h.1(l, localRunnable));
          }
        }
        a.b.B(paramViewGroup.avatar, str);
        AppMethodBeat.o(24086);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    final class a
    {
      ImageView avatar;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView
 * JD-Core Version:    0.7.0.1
 */