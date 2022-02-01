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
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends r<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> uOq = null;
  private boolean nXZ;
  private d uPq;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> uPr;
  private HashSet<String> uPs;
  private boolean uPt;
  ArrayList<k> uSO;
  private View.OnClickListener uSP;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25860);
    this.uPr = new HashMap();
    this.uPs = new HashSet();
    this.uPt = false;
    this.nXZ = false;
    this.uSP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25858);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        k localk;
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if (!com.tencent.mm.plugin.ipcall.a.c.fF(h.a(h.this)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25858);
            return;
          }
          localk = h.this.IL(i);
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
          g.yhR.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.d(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25858);
          return;
          label339:
          paramAnonymousView = i.ddM().xN(localk.field_addressId);
          break;
          label354:
          paramAnonymousView = new Intent(h.e(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          g.yhR.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.f(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
      }
    };
    xk(true);
    this.uPq = new d(paramContext);
    p.aEk().a(this);
    AppMethodBeat.o(25860);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(25868);
    if (this.uPs.contains(paramString)) {
      aq.f(new Runnable()
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
  
  public final k IL(int paramInt)
  {
    AppMethodBeat.i(25864);
    k localk = (k)this.uSO.get(paramInt);
    AppMethodBeat.o(25864);
    return localk;
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(221378);
    this.uSO = m.dep();
    AppMethodBeat.o(221378);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(193222);
    this.uSO = m.dep();
    AppMethodBeat.o(193222);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25863);
    if (this.uSO == null) {
      this.uSO = m.dep();
    }
    if (this.uSO != null)
    {
      int i = this.uSO.size();
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
      localView = LayoutInflater.from(this.context).inflate(2131494512, paramViewGroup, false);
      paramView = new a((byte)0);
      paramView.uPG = localView.findViewById(2131301153);
      paramView.uPH = localView.findViewById(2131299159);
      paramView.fRd = ((ImageView)localView.findViewById(2131297008));
      paramView.jcd = ((TextView)localView.findViewById(2131302867));
      paramView.uPy = ((TextView)localView.findViewById(2131303238));
      paramView.uPz = ((LinearLayout)localView.findViewById(2131303812));
      paramView.uPA = ((TextView)localView.findViewById(2131303815));
      paramView.uPB = ((TextView)localView.findViewById(2131303816));
      paramView.uPC = ((TextView)localView.findViewById(2131296493));
      paramView.uPD = ((TextView)localView.findViewById(2131296482));
      paramView.uPE = ((ImageView)localView.findViewById(2131296483));
      paramView.uPF = localView.findViewById(2131301156);
      paramView.uPF.setClickable(true);
      paramView.uPI = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    a locala = (a)localView.getTag();
    locala.uPF.setClickable(true);
    locala.uPF.setTag(Integer.valueOf(paramInt));
    locala.uPI.setVisibility(8);
    if (HY(paramInt))
    {
      locala.jcd.setVisibility(8);
      locala.uPy.setVisibility(8);
      locala.uPz.setVisibility(8);
      locala.fRd.setVisibility(8);
      locala.fRd.setTag(null);
      locala.uPD.setVisibility(8);
      locala.uPC.setVisibility(8);
      locala.uPE.setVisibility(8);
      AppMethodBeat.o(25865);
      return localView;
    }
    k localk = IL(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label809;
      }
      locala.uPD.setVisibility(0);
      locala.uPC.setVisibility(8);
      locala.uPD.setText(this.context.getString(2131760474));
      label416:
      locala.uPI.setVisibility(0);
      locala.jcd.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.uPG.getLayoutParams();
      paramView.height = ((int)locala.uPy.getContext().getResources().getDimension(2131165716));
      locala.uPG.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.fRd.getLayoutParams();
      paramView.height = ((int)locala.fRd.getContext().getResources().getDimension(2131165714));
      paramView.width = ((int)locala.fRd.getContext().getResources().getDimension(2131165714));
      locala.fRd.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label847;
      }
      if (!this.uPr.containsKey(Long.valueOf(localk.field_addressId))) {
        break label832;
      }
      paramView = (com.tencent.mm.plugin.ipcall.model.h.c)this.uPr.get(Long.valueOf(localk.field_addressId));
      label589:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.uPr.put(Long.valueOf(localk.field_addressId), paramView);
        locala.jcd.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label626:
      locala.uPy.setVisibility(8);
      locala.uPz.setVisibility(0);
      locala.uPB.setText(com.tencent.mm.plugin.ipcall.a.c.xR(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label868;
      }
      locala.uPA.setText(com.tencent.mm.plugin.ipcall.a.c.xV(localk.field_duration));
      label687:
      paramView = locala.fRd;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(2131232743);
        if (paramViewGroup != null)
        {
          if ((bt.isNullOrNil(paramViewGroup.field_contactId)) || (bt.isNullOrNil(paramViewGroup.field_wechatUsername))) {
            break label887;
          }
          this.uPq.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.uPs.add(paramViewGroup.field_wechatUsername);
      }
      locala.uPF.setVisibility(0);
      locala.uPE.setVisibility(0);
      locala.uPF.setOnClickListener(this.uSP);
      break;
      label809:
      locala.uPD.setVisibility(8);
      locala.uPC.setVisibility(8);
      break label416;
      label832:
      paramView = i.ddM().xN(localk.field_addressId);
      break label589;
      label847:
      locala.jcd.setText(com.tencent.mm.plugin.ipcall.a.a.aof(localk.field_phonenumber));
      paramViewGroup = null;
      break label626;
      label868:
      locala.uPA.setText(com.tencent.mm.plugin.ipcall.a.c.IQ(localk.field_status));
      break label687;
      label887:
      if (!bt.isNullOrNil(paramViewGroup.field_contactId)) {
        this.uPq.d(paramViewGroup.field_contactId, paramView);
      } else if (!bt.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.uPq.f(paramViewGroup.field_wechatUsername, paramView);
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
    this.uSO = m.dep();
    this.uPr.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25869);
  }
  
  final class a
  {
    ImageView fRd;
    TextView jcd;
    TextView uPA;
    TextView uPB;
    TextView uPC;
    TextView uPD;
    ImageView uPE;
    View uPF;
    View uPG;
    View uPH;
    ImageView uPI;
    TextView uPy;
    LinearLayout uPz;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */