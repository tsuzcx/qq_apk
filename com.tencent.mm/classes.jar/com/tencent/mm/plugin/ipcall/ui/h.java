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
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends r<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> tLD = null;
  private boolean nwB;
  private d tMD;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> tME;
  private HashSet<String> tMF;
  private boolean tMG;
  ArrayList<k> tQb;
  private View.OnClickListener tQc;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25860);
    this.tME = new HashMap();
    this.tMF = new HashSet();
    this.tMG = false;
    this.nwB = false;
    this.tQc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25858);
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if (!com.tencent.mm.plugin.ipcall.a.c.fA(h.a(h.this)))
          {
            AppMethodBeat.o(25858);
            return;
          }
          k localk = h.this.Hp(i);
          View localView = null;
          if (localk.field_addressId > 0L) {
            if (!h.b(h.this).containsKey(Long.valueOf(localk.field_addressId))) {
              break label286;
            }
          }
          label286:
          for (paramAnonymousView = (com.tencent.mm.plugin.ipcall.model.h.c)h.b(h.this).get(Long.valueOf(localk.field_addressId));; paramAnonymousView = i.cUB().vD(localk.field_addressId))
          {
            localView = paramAnonymousView;
            if (paramAnonymousView != null)
            {
              h.b(h.this).put(Long.valueOf(localk.field_addressId), paramAnonymousView);
              localView = paramAnonymousView;
            }
            if (localView == null) {
              break;
            }
            paramAnonymousView = new Intent(h.c(h.this), IPCallTalkUI.class);
            paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
            paramAnonymousView.putExtra("IPCallTalkUI_contactId", localView.field_contactId);
            paramAnonymousView.putExtra("IPCallTalkUI_nickname", localView.field_systemAddressBookUsername);
            paramAnonymousView.putExtra("IPCallTalkUI_toWechatUsername", localView.field_wechatUsername);
            paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
            com.tencent.mm.plugin.report.service.h.wUl.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
            ((FragmentActivity)h.d(h.this)).startActivityForResult(paramAnonymousView, 1001);
            AppMethodBeat.o(25858);
            return;
          }
          paramAnonymousView = new Intent(h.e(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          com.tencent.mm.plugin.report.service.h.wUl.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.f(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
        AppMethodBeat.o(25858);
      }
    };
    wy(true);
    this.tMD = new d(paramContext);
    p.aBh().a(this);
    AppMethodBeat.o(25860);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(25868);
    if (this.tMF.contains(paramString)) {
      ap.f(new Runnable()
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
  
  public final k Hp(int paramInt)
  {
    AppMethodBeat.i(25864);
    k localk = (k)this.tQb.get(paramInt);
    AppMethodBeat.o(25864);
    return localk;
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(210119);
    this.tQb = m.cVe();
    AppMethodBeat.o(210119);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(196002);
    this.tQb = m.cVe();
    AppMethodBeat.o(196002);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25863);
    if (this.tQb == null) {
      this.tQb = m.cVe();
    }
    if (this.tQb != null)
    {
      int i = this.tQb.size();
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
      paramView.tMT = localView.findViewById(2131301153);
      paramView.tMU = localView.findViewById(2131299159);
      paramView.fxQ = ((ImageView)localView.findViewById(2131297008));
      paramView.iIU = ((TextView)localView.findViewById(2131302867));
      paramView.tML = ((TextView)localView.findViewById(2131303238));
      paramView.tMM = ((LinearLayout)localView.findViewById(2131303812));
      paramView.tMN = ((TextView)localView.findViewById(2131303815));
      paramView.tMO = ((TextView)localView.findViewById(2131303816));
      paramView.tMP = ((TextView)localView.findViewById(2131296493));
      paramView.tMQ = ((TextView)localView.findViewById(2131296482));
      paramView.tMR = ((ImageView)localView.findViewById(2131296483));
      paramView.tMS = localView.findViewById(2131301156);
      paramView.tMS.setClickable(true);
      paramView.tMV = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    a locala = (a)localView.getTag();
    locala.tMS.setClickable(true);
    locala.tMS.setTag(Integer.valueOf(paramInt));
    locala.tMV.setVisibility(8);
    if (GF(paramInt))
    {
      locala.iIU.setVisibility(8);
      locala.tML.setVisibility(8);
      locala.tMM.setVisibility(8);
      locala.fxQ.setVisibility(8);
      locala.fxQ.setTag(null);
      locala.tMQ.setVisibility(8);
      locala.tMP.setVisibility(8);
      locala.tMR.setVisibility(8);
      AppMethodBeat.o(25865);
      return localView;
    }
    k localk = Hp(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label809;
      }
      locala.tMQ.setVisibility(0);
      locala.tMP.setVisibility(8);
      locala.tMQ.setText(this.context.getString(2131760474));
      label416:
      locala.tMV.setVisibility(0);
      locala.iIU.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.tMT.getLayoutParams();
      paramView.height = ((int)locala.tML.getContext().getResources().getDimension(2131165716));
      locala.tMT.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.fxQ.getLayoutParams();
      paramView.height = ((int)locala.fxQ.getContext().getResources().getDimension(2131165714));
      paramView.width = ((int)locala.fxQ.getContext().getResources().getDimension(2131165714));
      locala.fxQ.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label847;
      }
      if (!this.tME.containsKey(Long.valueOf(localk.field_addressId))) {
        break label832;
      }
      paramView = (com.tencent.mm.plugin.ipcall.model.h.c)this.tME.get(Long.valueOf(localk.field_addressId));
      label589:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.tME.put(Long.valueOf(localk.field_addressId), paramView);
        locala.iIU.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label626:
      locala.tML.setVisibility(8);
      locala.tMM.setVisibility(0);
      locala.tMO.setText(com.tencent.mm.plugin.ipcall.a.c.vH(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label868;
      }
      locala.tMN.setText(com.tencent.mm.plugin.ipcall.a.c.vL(localk.field_duration));
      label687:
      paramView = locala.fxQ;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(2131232743);
        if (paramViewGroup != null)
        {
          if ((bs.isNullOrNil(paramViewGroup.field_contactId)) || (bs.isNullOrNil(paramViewGroup.field_wechatUsername))) {
            break label887;
          }
          this.tMD.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.tMF.add(paramViewGroup.field_wechatUsername);
      }
      locala.tMS.setVisibility(0);
      locala.tMR.setVisibility(0);
      locala.tMS.setOnClickListener(this.tQc);
      break;
      label809:
      locala.tMQ.setVisibility(8);
      locala.tMP.setVisibility(8);
      break label416;
      label832:
      paramView = i.cUB().vD(localk.field_addressId);
      break label589;
      label847:
      locala.iIU.setText(a.ajs(localk.field_phonenumber));
      paramViewGroup = null;
      break label626;
      label868:
      locala.tMN.setText(com.tencent.mm.plugin.ipcall.a.c.Hu(localk.field_status));
      break label687;
      label887:
      if (!bs.isNullOrNil(paramViewGroup.field_contactId)) {
        this.tMD.c(paramViewGroup.field_contactId, paramView);
      } else if (!bs.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.tMD.e(paramViewGroup.field_wechatUsername, paramView);
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
    this.tQb = m.cVe();
    this.tME.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25869);
  }
  
  final class a
  {
    ImageView fxQ;
    TextView iIU;
    TextView tML;
    LinearLayout tMM;
    TextView tMN;
    TextView tMO;
    TextView tMP;
    TextView tMQ;
    ImageView tMR;
    View tMS;
    View tMT;
    View tMU;
    ImageView tMV;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */