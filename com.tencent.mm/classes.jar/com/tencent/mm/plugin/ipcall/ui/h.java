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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends r<com.tencent.mm.plugin.ipcall.model.h.c>
  implements e.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> vad = null;
  private boolean odI;
  private d vbc;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> vbd;
  private HashSet<String> vbe;
  private boolean vbf;
  ArrayList<k> veB;
  private View.OnClickListener veC;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25860);
    this.vbd = new HashMap();
    this.vbe = new HashSet();
    this.vbf = false;
    this.odI = false;
    this.veC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25858);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        k localk;
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if (!com.tencent.mm.plugin.ipcall.a.c.fK(h.a(h.this)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25858);
            return;
          }
          localk = h.this.Jj(i);
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
          g.yxI.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.d(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25858);
          return;
          label339:
          paramAnonymousView = i.dgE().yh(localk.field_addressId);
          break;
          label354:
          paramAnonymousView = new Intent(h.e(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          g.yxI.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.f(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
      }
    };
    xs(true);
    this.vbc = new d(paramContext);
    p.aEA().a(this);
    AppMethodBeat.o(25860);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(25868);
    if (this.vbe.contains(paramString)) {
      ar.f(new Runnable()
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
  
  public final k Jj(int paramInt)
  {
    AppMethodBeat.i(25864);
    k localk = (k)this.veB.get(paramInt);
    AppMethodBeat.o(25864);
    return localk;
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(224183);
    this.veB = m.dhh();
    AppMethodBeat.o(224183);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(186482);
    this.veB = m.dhh();
    AppMethodBeat.o(186482);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25863);
    if (this.veB == null) {
      this.veB = m.dhh();
    }
    if (this.veB != null)
    {
      int i = this.veB.size();
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
      paramView.vbs = localView.findViewById(2131301153);
      paramView.vbt = localView.findViewById(2131299159);
      paramView.fTj = ((ImageView)localView.findViewById(2131297008));
      paramView.jeW = ((TextView)localView.findViewById(2131302867));
      paramView.vbk = ((TextView)localView.findViewById(2131303238));
      paramView.vbl = ((LinearLayout)localView.findViewById(2131303812));
      paramView.vbm = ((TextView)localView.findViewById(2131303815));
      paramView.vbn = ((TextView)localView.findViewById(2131303816));
      paramView.vbo = ((TextView)localView.findViewById(2131296493));
      paramView.vbp = ((TextView)localView.findViewById(2131296482));
      paramView.vbq = ((ImageView)localView.findViewById(2131296483));
      paramView.vbr = localView.findViewById(2131301156);
      paramView.vbr.setClickable(true);
      paramView.vbu = ((ImageView)localView.findViewById(2131299154));
      localView.setTag(paramView);
    }
    a locala = (a)localView.getTag();
    locala.vbr.setClickable(true);
    locala.vbr.setTag(Integer.valueOf(paramInt));
    locala.vbu.setVisibility(8);
    if (Iw(paramInt))
    {
      locala.jeW.setVisibility(8);
      locala.vbk.setVisibility(8);
      locala.vbl.setVisibility(8);
      locala.fTj.setVisibility(8);
      locala.fTj.setTag(null);
      locala.vbp.setVisibility(8);
      locala.vbo.setVisibility(8);
      locala.vbq.setVisibility(8);
      AppMethodBeat.o(25865);
      return localView;
    }
    k localk = Jj(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label809;
      }
      locala.vbp.setVisibility(0);
      locala.vbo.setVisibility(8);
      locala.vbp.setText(this.context.getString(2131760474));
      label416:
      locala.vbu.setVisibility(0);
      locala.jeW.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.vbs.getLayoutParams();
      paramView.height = ((int)locala.vbk.getContext().getResources().getDimension(2131165716));
      locala.vbs.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.fTj.getLayoutParams();
      paramView.height = ((int)locala.fTj.getContext().getResources().getDimension(2131165714));
      paramView.width = ((int)locala.fTj.getContext().getResources().getDimension(2131165714));
      locala.fTj.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label847;
      }
      if (!this.vbd.containsKey(Long.valueOf(localk.field_addressId))) {
        break label832;
      }
      paramView = (com.tencent.mm.plugin.ipcall.model.h.c)this.vbd.get(Long.valueOf(localk.field_addressId));
      label589:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.vbd.put(Long.valueOf(localk.field_addressId), paramView);
        locala.jeW.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label626:
      locala.vbk.setVisibility(8);
      locala.vbl.setVisibility(0);
      locala.vbn.setText(com.tencent.mm.plugin.ipcall.a.c.yl(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label868;
      }
      locala.vbm.setText(com.tencent.mm.plugin.ipcall.a.c.yp(localk.field_duration));
      label687:
      paramView = locala.fTj;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(2131232743);
        if (paramViewGroup != null)
        {
          if ((bu.isNullOrNil(paramViewGroup.field_contactId)) || (bu.isNullOrNil(paramViewGroup.field_wechatUsername))) {
            break label887;
          }
          this.vbc.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.vbe.add(paramViewGroup.field_wechatUsername);
      }
      locala.vbr.setVisibility(0);
      locala.vbq.setVisibility(0);
      locala.vbr.setOnClickListener(this.veC);
      break;
      label809:
      locala.vbp.setVisibility(8);
      locala.vbo.setVisibility(8);
      break label416;
      label832:
      paramView = i.dgE().yh(localk.field_addressId);
      break label589;
      label847:
      locala.jeW.setText(com.tencent.mm.plugin.ipcall.a.a.aph(localk.field_phonenumber));
      paramViewGroup = null;
      break label626;
      label868:
      locala.vbm.setText(com.tencent.mm.plugin.ipcall.a.c.Jo(localk.field_status));
      break label687;
      label887:
      if (!bu.isNullOrNil(paramViewGroup.field_contactId)) {
        this.vbc.d(paramViewGroup.field_contactId, paramView);
      } else if (!bu.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.vbc.f(paramViewGroup.field_wechatUsername, paramView);
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
    this.veB = m.dhh();
    this.vbd.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25869);
  }
  
  final class a
  {
    ImageView fTj;
    TextView jeW;
    TextView vbk;
    LinearLayout vbl;
    TextView vbm;
    TextView vbn;
    TextView vbo;
    TextView vbp;
    ImageView vbq;
    View vbr;
    View vbs;
    View vbt;
    ImageView vbu;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */