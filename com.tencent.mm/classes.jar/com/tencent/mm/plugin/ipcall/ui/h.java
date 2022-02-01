package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends s<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> ysD = null;
  private boolean poG;
  private d ytC;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> ytD;
  private HashSet<String> ytE;
  private boolean ytF;
  ArrayList<k> yxa;
  private View.OnClickListener yxb;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25860);
    this.ytD = new HashMap();
    this.ytE = new HashSet();
    this.ytF = false;
    this.poG = false;
    this.yxb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25858);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        k localk;
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if (!com.tencent.mm.plugin.ipcall.a.c.gq(h.a(h.this)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25858);
            return;
          }
          localk = h.this.Pm(i);
          localObject = null;
          if (localk.field_addressId > 0L)
          {
            if (!h.b(h.this).containsKey(Long.valueOf(localk.field_addressId))) {
              break label339;
            }
            paramAnonymousView = (com.tencent.mm.plugin.ipcall.model.h.c)h.b(h.this).get(Long.valueOf(localk.field_addressId));
            localObject = paramAnonymousView;
            if (paramAnonymousView != null)
            {
              h.b(h.this).put(Long.valueOf(localk.field_addressId), paramAnonymousView);
              localObject = paramAnonymousView;
            }
          }
          if (localObject == null) {
            break label354;
          }
          paramAnonymousView = new Intent(h.c(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_contactId", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallTalkUI_nickname", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallTalkUI_toWechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          com.tencent.mm.plugin.report.service.h.CyF.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.d(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25858);
          return;
          label339:
          paramAnonymousView = i.eay().GR(localk.field_addressId);
          break;
          label354:
          paramAnonymousView = new Intent(h.e(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          com.tencent.mm.plugin.report.service.h.CyF.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.f(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
      }
    };
    Bh(true);
    this.ytC = new d(paramContext);
    p.aYn().a(this);
    AppMethodBeat.o(25860);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(25868);
    if (this.ytE.contains(paramString)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25859);
          h.this.notifyDataSetChanged();
          AppMethodBeat.o(25859);
        }
      });
    }
    AppMethodBeat.o(25868);
  }
  
  public final k Pm(int paramInt)
  {
    AppMethodBeat.i(25864);
    k localk = (k)this.yxa.get(paramInt);
    AppMethodBeat.o(25864);
    return localk;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(258235);
    this.yxa = m.ebb();
    AppMethodBeat.o(258235);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(257950);
    this.yxa = m.ebb();
    AppMethodBeat.o(257950);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25863);
    if (this.yxa == null) {
      this.yxa = m.ebb();
    }
    if (this.yxa != null)
    {
      int i = this.yxa.size();
      AppMethodBeat.o(25863);
      return i;
    }
    AppMethodBeat.o(25863);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(25866);
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(25866);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25865);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495104, paramViewGroup, false);
      paramView = new a((byte)0);
      paramView.ytS = localView.findViewById(2131302811);
      paramView.ytT = localView.findViewById(2131299703);
      paramView.gyr = ((ImageView)localView.findViewById(2131297134));
      paramView.kcZ = ((TextView)localView.findViewById(2131305440));
      paramView.ytK = ((TextView)localView.findViewById(2131305906));
      paramView.ytL = ((LinearLayout)localView.findViewById(2131306615));
      paramView.ytM = ((TextView)localView.findViewById(2131306618));
      paramView.ytN = ((TextView)localView.findViewById(2131306619));
      paramView.ytO = ((TextView)localView.findViewById(2131296567));
      paramView.ytP = ((TextView)localView.findViewById(2131296556));
      paramView.ytQ = ((ImageView)localView.findViewById(2131296557));
      paramView.ytR = localView.findViewById(2131302816);
      paramView.ytR.setClickable(true);
      paramView.ytU = ((ImageView)localView.findViewById(2131299682));
      localView.setTag(paramView);
    }
    a locala = (a)localView.getTag();
    locala.ytR.setClickable(true);
    locala.ytR.setTag(Integer.valueOf(paramInt));
    locala.ytU.setVisibility(8);
    if (Ox(paramInt))
    {
      locala.kcZ.setVisibility(8);
      locala.ytK.setVisibility(8);
      locala.ytL.setVisibility(8);
      locala.gyr.setVisibility(8);
      locala.gyr.setTag(null);
      locala.ytP.setVisibility(8);
      locala.ytO.setVisibility(8);
      locala.ytQ.setVisibility(8);
      AppMethodBeat.o(25865);
      return localView;
    }
    k localk = Pm(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label809;
      }
      locala.ytP.setVisibility(0);
      locala.ytO.setVisibility(8);
      locala.ytP.setText(this.context.getString(2131761919));
      label416:
      locala.ytU.setVisibility(0);
      locala.kcZ.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.ytS.getLayoutParams();
      paramView.height = ((int)locala.ytK.getContext().getResources().getDimension(2131165734));
      locala.ytS.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.gyr.getLayoutParams();
      paramView.height = ((int)locala.gyr.getContext().getResources().getDimension(2131165732));
      paramView.width = ((int)locala.gyr.getContext().getResources().getDimension(2131165732));
      locala.gyr.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label847;
      }
      if (!this.ytD.containsKey(Long.valueOf(localk.field_addressId))) {
        break label832;
      }
      paramView = (com.tencent.mm.plugin.ipcall.model.h.c)this.ytD.get(Long.valueOf(localk.field_addressId));
      label589:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.ytD.put(Long.valueOf(localk.field_addressId), paramView);
        locala.kcZ.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label626:
      locala.ytK.setVisibility(8);
      locala.ytL.setVisibility(0);
      locala.ytN.setText(com.tencent.mm.plugin.ipcall.a.c.GU(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label868;
      }
      locala.ytM.setText(com.tencent.mm.plugin.ipcall.a.c.GY(localk.field_duration));
      label687:
      paramView = locala.gyr;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(2131233183);
        if (paramViewGroup != null)
        {
          if ((Util.isNullOrNil(paramViewGroup.field_contactId)) || (Util.isNullOrNil(paramViewGroup.field_wechatUsername))) {
            break label887;
          }
          this.ytC.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.ytE.add(paramViewGroup.field_wechatUsername);
      }
      locala.ytR.setVisibility(0);
      locala.ytQ.setVisibility(0);
      locala.ytR.setOnClickListener(this.yxb);
      break;
      label809:
      locala.ytP.setVisibility(8);
      locala.ytO.setVisibility(8);
      break label416;
      label832:
      paramView = i.eay().GR(localk.field_addressId);
      break label589;
      label847:
      locala.kcZ.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(localk.field_phonenumber));
      paramViewGroup = null;
      break label626;
      label868:
      locala.ytM.setText(com.tencent.mm.plugin.ipcall.a.c.Pr(localk.field_status));
      break label687;
      label887:
      if (!Util.isNullOrNil(paramViewGroup.field_contactId)) {
        this.ytC.d(paramViewGroup.field_contactId, paramView);
      } else if (!Util.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.ytC.f(paramViewGroup.field_wechatUsername, paramView);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(25867);
    int i = super.getViewTypeCount();
    AppMethodBeat.o(25867);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(25869);
    this.yxa = m.ebb();
    this.ytD.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25869);
  }
  
  final class a
  {
    ImageView gyr;
    TextView kcZ;
    TextView ytK;
    LinearLayout ytL;
    TextView ytM;
    TextView ytN;
    TextView ytO;
    TextView ytP;
    ImageView ytQ;
    View ytR;
    View ytS;
    View ytT;
    ImageView ytU;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */