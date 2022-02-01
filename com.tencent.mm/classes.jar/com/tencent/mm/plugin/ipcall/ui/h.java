package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends x<com.tencent.mm.plugin.ipcall.model.h.c>
  implements AvatarStorage.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> JJR = null;
  private d JKQ;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> JKR;
  private HashSet<String> JKS;
  private boolean JKT;
  ArrayList<k> JOn;
  private View.OnClickListener JOo;
  private boolean vDm;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25860);
    this.JKR = new HashMap();
    this.JKS = new HashSet();
    this.JKT = false;
    this.vDm = false;
    this.JOo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25858);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        k localk;
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if (!com.tencent.mm.plugin.ipcall.a.c.iI(h.a(h.this)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25858);
            return;
          }
          localk = h.this.Zq(i);
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
          com.tencent.mm.plugin.report.service.h.OAn.b(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.d(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25858);
          return;
          label339:
          paramAnonymousView = com.tencent.mm.plugin.ipcall.model.h.fRw().sb(localk.field_addressId);
          break;
          label354:
          paramAnonymousView = new Intent(h.e(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          com.tencent.mm.plugin.report.service.h.OAn.b(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.f(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
      }
    };
    Lh(true);
    this.JKQ = new d(paramContext);
    q.bFp().a(this);
    AppMethodBeat.o(25860);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(25868);
    if (this.JKS.contains(paramString)) {
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
  
  public final k Zq(int paramInt)
  {
    AppMethodBeat.i(25864);
    k localk = (k)this.JOn.get(paramInt);
    AppMethodBeat.o(25864);
    return localk;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(369888);
    this.JOn = m.fRZ();
    AppMethodBeat.o(369888);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(303669);
    this.JOn = m.fRZ();
    AppMethodBeat.o(303669);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25863);
    if (this.JOn == null) {
      this.JOn = m.fRZ();
    }
    if (this.JOn != null)
    {
      int i = this.JOn.size();
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
      localView = LayoutInflater.from(this.context).inflate(R.i.gkS, paramViewGroup, false);
      paramView = new a((byte)0);
      paramView.JLg = localView.findViewById(R.h.fLC);
      paramView.JLh = localView.findViewById(R.h.divider_bottom);
      paramView.lKK = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.pRg = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramView.JKY = ((TextView)localView.findViewById(R.h.fTj));
      paramView.JKZ = ((LinearLayout)localView.findViewById(R.h.fUh));
      paramView.JLa = ((TextView)localView.findViewById(R.h.fUi));
      paramView.JLb = ((TextView)localView.findViewById(R.h.fUj));
      paramView.JLc = ((TextView)localView.findViewById(R.h.fqO));
      paramView.JLd = ((TextView)localView.findViewById(R.h.fqH));
      paramView.JLe = ((ImageView)localView.findViewById(R.h.fqI));
      paramView.JLf = localView.findViewById(R.h.fLD);
      paramView.JLf.setClickable(true);
      paramView.JLi = ((ImageView)localView.findViewById(R.h.divider));
      localView.setTag(paramView);
    }
    a locala = (a)localView.getTag();
    locala.JLf.setClickable(true);
    locala.JLf.setTag(Integer.valueOf(paramInt));
    locala.JLi.setVisibility(8);
    if (XL(paramInt))
    {
      locala.pRg.setVisibility(8);
      locala.JKY.setVisibility(8);
      locala.JKZ.setVisibility(8);
      locala.lKK.setVisibility(8);
      locala.lKK.setTag(null);
      locala.JLd.setVisibility(8);
      locala.JLc.setVisibility(8);
      locala.JLe.setVisibility(8);
      AppMethodBeat.o(25865);
      return localView;
    }
    k localk = Zq(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label823;
      }
      locala.JLd.setVisibility(0);
      locala.JLc.setVisibility(8);
      locala.JLd.setText(this.context.getString(R.l.gKG));
      label430:
      locala.JLi.setVisibility(0);
      locala.pRg.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.JLg.getLayoutParams();
      paramView.height = ((int)locala.JKY.getContext().getResources().getDimension(R.f.flr));
      locala.JLg.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.lKK.getLayoutParams();
      paramView.height = ((int)locala.lKK.getContext().getResources().getDimension(R.f.flq));
      paramView.width = ((int)locala.lKK.getContext().getResources().getDimension(R.f.flq));
      locala.lKK.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label861;
      }
      if (!this.JKR.containsKey(Long.valueOf(localk.field_addressId))) {
        break label846;
      }
      paramView = (com.tencent.mm.plugin.ipcall.model.h.c)this.JKR.get(Long.valueOf(localk.field_addressId));
      label603:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.JKR.put(Long.valueOf(localk.field_addressId), paramView);
        locala.pRg.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label640:
      locala.JKY.setVisibility(8);
      locala.JKZ.setVisibility(0);
      locala.JLb.setText(com.tencent.mm.plugin.ipcall.a.c.se(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label882;
      }
      locala.JLa.setText(com.tencent.mm.plugin.ipcall.a.c.si(localk.field_duration));
      label701:
      paramView = locala.lKK;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(R.g.fnV);
        if (paramViewGroup != null)
        {
          if ((Util.isNullOrNil(paramViewGroup.field_contactId)) || (Util.isNullOrNil(paramViewGroup.field_wechatUsername))) {
            break label901;
          }
          this.JKQ.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.JKS.add(paramViewGroup.field_wechatUsername);
      }
      locala.JLf.setVisibility(0);
      locala.JLe.setVisibility(0);
      locala.JLf.setOnClickListener(this.JOo);
      break;
      label823:
      locala.JLd.setVisibility(8);
      locala.JLc.setVisibility(8);
      break label430;
      label846:
      paramView = com.tencent.mm.plugin.ipcall.model.h.fRw().sb(localk.field_addressId);
      break label603;
      label861:
      locala.pRg.setText(com.tencent.mm.plugin.ipcall.a.a.aJB(localk.field_phonenumber));
      paramViewGroup = null;
      break label640;
      label882:
      locala.JLa.setText(com.tencent.mm.plugin.ipcall.a.c.Zv(localk.field_status));
      break label701;
      label901:
      if (!Util.isNullOrNil(paramViewGroup.field_contactId)) {
        this.JKQ.e(paramViewGroup.field_contactId, paramView);
      } else if (!Util.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.JKQ.g(paramViewGroup.field_wechatUsername, paramView);
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
    this.JOn = m.fRZ();
    this.JKR.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25869);
  }
  
  final class a
  {
    TextView JKY;
    LinearLayout JKZ;
    TextView JLa;
    TextView JLb;
    TextView JLc;
    TextView JLd;
    ImageView JLe;
    View JLf;
    View JLg;
    View JLh;
    ImageView JLi;
    ImageView lKK;
    TextView pRg;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */