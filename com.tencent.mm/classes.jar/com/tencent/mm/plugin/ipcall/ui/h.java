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
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends q<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> sDW = null;
  private boolean mUj;
  private d sEW;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> sEX;
  private HashSet<String> sEY;
  private boolean sEZ;
  ArrayList<k> sIv;
  private View.OnClickListener sIw;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25860);
    this.sEX = new HashMap();
    this.sEY = new HashSet();
    this.sEZ = false;
    this.mUj = false;
    this.sIw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25858);
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if (!com.tencent.mm.plugin.ipcall.a.c.fn(h.a(h.this)))
          {
            AppMethodBeat.o(25858);
            return;
          }
          k localk = h.this.Fu(i);
          View localView = null;
          if (localk.field_addressId > 0L) {
            if (!h.b(h.this).containsKey(Long.valueOf(localk.field_addressId))) {
              break label286;
            }
          }
          label286:
          for (paramAnonymousView = (com.tencent.mm.plugin.ipcall.model.h.c)h.b(h.this).get(Long.valueOf(localk.field_addressId));; paramAnonymousView = i.cHq().ra(localk.field_addressId))
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
            com.tencent.mm.plugin.report.service.h.vKh.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
            ((FragmentActivity)h.d(h.this)).startActivityForResult(paramAnonymousView, 1001);
            AppMethodBeat.o(25858);
            return;
          }
          paramAnonymousView = new Intent(h.e(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          com.tencent.mm.plugin.report.service.h.vKh.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.f(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
        AppMethodBeat.o(25858);
      }
    };
    vw(true);
    this.sEW = new d(paramContext);
    p.auq().a(this);
    AppMethodBeat.o(25860);
  }
  
  public final k Fu(int paramInt)
  {
    AppMethodBeat.i(25864);
    k localk = (k)this.sIv.get(paramInt);
    AppMethodBeat.o(25864);
    return localk;
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(204847);
    this.sIv = m.cHT();
    AppMethodBeat.o(204847);
  }
  
  public final void We()
  {
    AppMethodBeat.i(196986);
    this.sIv = m.cHT();
    AppMethodBeat.o(196986);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25863);
    if (this.sIv == null) {
      this.sIv = m.cHT();
    }
    if (this.sIv != null)
    {
      int i = this.sIv.size();
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
      paramView.sFm = localView.findViewById(2131301153);
      paramView.sFn = localView.findViewById(2131299159);
      paramView.fuj = ((ImageView)localView.findViewById(2131297008));
      paramView.iiN = ((TextView)localView.findViewById(2131302867));
      paramView.sFe = ((TextView)localView.findViewById(2131303238));
      paramView.sFf = ((LinearLayout)localView.findViewById(2131303812));
      paramView.sFg = ((TextView)localView.findViewById(2131303815));
      paramView.sFh = ((TextView)localView.findViewById(2131303816));
      paramView.sFi = ((TextView)localView.findViewById(2131296493));
      paramView.sFj = ((TextView)localView.findViewById(2131296482));
      paramView.sFk = ((ImageView)localView.findViewById(2131296483));
      paramView.sFl = localView.findViewById(2131301156);
      paramView.sFl.setClickable(true);
      paramView.sFo = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    a locala = (a)localView.getTag();
    locala.sFl.setClickable(true);
    locala.sFl.setTag(Integer.valueOf(paramInt));
    locala.sFo.setVisibility(8);
    if (EJ(paramInt))
    {
      locala.iiN.setVisibility(8);
      locala.sFe.setVisibility(8);
      locala.sFf.setVisibility(8);
      locala.fuj.setVisibility(8);
      locala.fuj.setTag(null);
      locala.sFj.setVisibility(8);
      locala.sFi.setVisibility(8);
      locala.sFk.setVisibility(8);
      AppMethodBeat.o(25865);
      return localView;
    }
    k localk = Fu(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label809;
      }
      locala.sFj.setVisibility(0);
      locala.sFi.setVisibility(8);
      locala.sFj.setText(this.context.getString(2131760474));
      label416:
      locala.sFo.setVisibility(0);
      locala.iiN.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.sFm.getLayoutParams();
      paramView.height = ((int)locala.sFe.getContext().getResources().getDimension(2131165716));
      locala.sFm.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.fuj.getLayoutParams();
      paramView.height = ((int)locala.fuj.getContext().getResources().getDimension(2131165714));
      paramView.width = ((int)locala.fuj.getContext().getResources().getDimension(2131165714));
      locala.fuj.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label847;
      }
      if (!this.sEX.containsKey(Long.valueOf(localk.field_addressId))) {
        break label832;
      }
      paramView = (com.tencent.mm.plugin.ipcall.model.h.c)this.sEX.get(Long.valueOf(localk.field_addressId));
      label589:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.sEX.put(Long.valueOf(localk.field_addressId), paramView);
        locala.iiN.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label626:
      locala.sFe.setVisibility(8);
      locala.sFf.setVisibility(0);
      locala.sFh.setText(com.tencent.mm.plugin.ipcall.a.c.re(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label868;
      }
      locala.sFg.setText(com.tencent.mm.plugin.ipcall.a.c.ri(localk.field_duration));
      label687:
      paramView = locala.fuj;
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
          this.sEW.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.sEY.add(paramViewGroup.field_wechatUsername);
      }
      locala.sFl.setVisibility(0);
      locala.sFk.setVisibility(0);
      locala.sFl.setOnClickListener(this.sIw);
      break;
      label809:
      locala.sFj.setVisibility(8);
      locala.sFi.setVisibility(8);
      break label416;
      label832:
      paramView = i.cHq().ra(localk.field_addressId);
      break label589;
      label847:
      locala.iiN.setText(a.aeA(localk.field_phonenumber));
      paramViewGroup = null;
      break label626;
      label868:
      locala.sFg.setText(com.tencent.mm.plugin.ipcall.a.c.Fz(localk.field_status));
      break label687;
      label887:
      if (!bt.isNullOrNil(paramViewGroup.field_contactId)) {
        this.sEW.c(paramViewGroup.field_contactId, paramView);
      } else if (!bt.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.sEW.e(paramViewGroup.field_wechatUsername, paramView);
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
    this.sIv = m.cHT();
    this.sEX.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25869);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(25868);
    if (this.sEY.contains(paramString)) {
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
  
  final class a
  {
    ImageView fuj;
    TextView iiN;
    TextView sFe;
    LinearLayout sFf;
    TextView sFg;
    TextView sFh;
    TextView sFi;
    TextView sFj;
    ImageView sFk;
    View sFl;
    View sFm;
    View sFn;
    ImageView sFo;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */