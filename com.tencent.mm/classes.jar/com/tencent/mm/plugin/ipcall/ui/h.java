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
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h
  extends v<com.tencent.mm.plugin.ipcall.model.h.c>
  implements f.a
{
  private static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> DSH = null;
  private d DTG;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> DTH;
  private HashSet<String> DTI;
  private boolean DTJ;
  ArrayList<k> DXe;
  private View.OnClickListener DXf;
  private boolean sxF;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25860);
    this.DTH = new HashMap();
    this.DTI = new HashSet();
    this.DTJ = false;
    this.sxF = false;
    this.DXf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25858);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        k localk;
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if (!com.tencent.mm.plugin.ipcall.a.c.hn(h.a(h.this)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25858);
            return;
          }
          localk = h.this.Vv(i);
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
          com.tencent.mm.plugin.report.service.h.IzE.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.d(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRecentRecordAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25858);
          return;
          label339:
          paramAnonymousView = i.eJw().Og(localk.field_addressId);
          break;
          label354:
          paramAnonymousView = new Intent(h.e(h.this), IPCallTalkUI.class);
          paramAnonymousView.putExtra("IPCallTalkUI_phoneNumber", localk.field_phonenumber);
          paramAnonymousView.putExtra("IPCallTalkUI_dialScene", 3);
          com.tencent.mm.plugin.report.service.h.IzE.a(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          ((FragmentActivity)h.f(h.this)).startActivityForResult(paramAnonymousView, 1001);
        }
      }
    };
    Fx(true);
    this.DTG = new d(paramContext);
    q.bhz().a(this);
    AppMethodBeat.o(25860);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(25868);
    if (this.DTI.contains(paramString)) {
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
  
  public final k Vv(int paramInt)
  {
    AppMethodBeat.i(25864);
    k localk = (k)this.DXe.get(paramInt);
    AppMethodBeat.o(25864);
    return localk;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(293353);
    this.DXe = m.eJZ();
    AppMethodBeat.o(293353);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(292698);
    this.DXe = m.eJZ();
    AppMethodBeat.o(292698);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25863);
    if (this.DXe == null) {
      this.DXe = m.eJZ();
    }
    if (this.DXe != null)
    {
      int i = this.DXe.size();
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
      localView = LayoutInflater.from(this.context).inflate(R.i.ehX, paramViewGroup, false);
      paramView = new a((byte)0);
      paramView.DTW = localView.findViewById(R.h.dKh);
      paramView.DTX = localView.findViewById(R.h.divider_bottom);
      paramView.jiu = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.mUy = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramView.DTO = ((TextView)localView.findViewById(R.h.dRd));
      paramView.DTP = ((LinearLayout)localView.findViewById(R.h.dSh));
      paramView.DTQ = ((TextView)localView.findViewById(R.h.dSi));
      paramView.DTR = ((TextView)localView.findViewById(R.h.dSj));
      paramView.DTS = ((TextView)localView.findViewById(R.h.dqA));
      paramView.DTT = ((TextView)localView.findViewById(R.h.dqt));
      paramView.DTU = ((ImageView)localView.findViewById(R.h.dqu));
      paramView.DTV = localView.findViewById(R.h.dKi);
      paramView.DTV.setClickable(true);
      paramView.DTY = ((ImageView)localView.findViewById(R.h.divider));
      localView.setTag(paramView);
    }
    a locala = (a)localView.getTag();
    locala.DTV.setClickable(true);
    locala.DTV.setTag(Integer.valueOf(paramInt));
    locala.DTY.setVisibility(8);
    if (TR(paramInt))
    {
      locala.mUy.setVisibility(8);
      locala.DTO.setVisibility(8);
      locala.DTP.setVisibility(8);
      locala.jiu.setVisibility(8);
      locala.jiu.setTag(null);
      locala.DTT.setVisibility(8);
      locala.DTS.setVisibility(8);
      locala.DTU.setVisibility(8);
      AppMethodBeat.o(25865);
      return localView;
    }
    k localk = Vv(paramInt);
    if (localk != null)
    {
      if (paramInt != 0) {
        break label823;
      }
      locala.DTT.setVisibility(0);
      locala.DTS.setVisibility(8);
      locala.DTT.setText(this.context.getString(R.l.eIZ));
      label430:
      locala.DTY.setVisibility(0);
      locala.mUy.setVisibility(0);
      paramView = (FrameLayout.LayoutParams)locala.DTW.getLayoutParams();
      paramView.height = ((int)locala.DTO.getContext().getResources().getDimension(R.f.dlb));
      locala.DTW.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)locala.jiu.getLayoutParams();
      paramView.height = ((int)locala.jiu.getContext().getResources().getDimension(R.f.dla));
      paramView.width = ((int)locala.jiu.getContext().getResources().getDimension(R.f.dla));
      locala.jiu.setLayoutParams(paramView);
      if (localk.field_addressId <= 0L) {
        break label861;
      }
      if (!this.DTH.containsKey(Long.valueOf(localk.field_addressId))) {
        break label846;
      }
      paramView = (com.tencent.mm.plugin.ipcall.model.h.c)this.DTH.get(Long.valueOf(localk.field_addressId));
      label603:
      paramViewGroup = paramView;
      if (paramView != null)
      {
        this.DTH.put(Long.valueOf(localk.field_addressId), paramView);
        locala.mUy.setText(paramView.field_systemAddressBookUsername);
        paramViewGroup = paramView;
      }
      label640:
      locala.DTO.setVisibility(8);
      locala.DTP.setVisibility(0);
      locala.DTR.setText(com.tencent.mm.plugin.ipcall.a.c.Oj(localk.field_calltime));
      if (localk.field_duration <= 0L) {
        break label882;
      }
      locala.DTQ.setText(com.tencent.mm.plugin.ipcall.a.c.On(localk.field_duration));
      label701:
      paramView = locala.jiu;
      if (paramView != null)
      {
        paramView.setVisibility(0);
        paramView.setTag(null);
        paramView.setImageResource(R.g.dnG);
        if (paramViewGroup != null)
        {
          if ((Util.isNullOrNil(paramViewGroup.field_contactId)) || (Util.isNullOrNil(paramViewGroup.field_wechatUsername))) {
            break label901;
          }
          this.DTG.a(paramViewGroup.field_contactId, paramViewGroup.field_wechatUsername, paramView);
        }
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.DTI.add(paramViewGroup.field_wechatUsername);
      }
      locala.DTV.setVisibility(0);
      locala.DTU.setVisibility(0);
      locala.DTV.setOnClickListener(this.DXf);
      break;
      label823:
      locala.DTT.setVisibility(8);
      locala.DTS.setVisibility(8);
      break label430;
      label846:
      paramView = i.eJw().Og(localk.field_addressId);
      break label603;
      label861:
      locala.mUy.setText(com.tencent.mm.plugin.ipcall.a.a.aMH(localk.field_phonenumber));
      paramViewGroup = null;
      break label640;
      label882:
      locala.DTQ.setText(com.tencent.mm.plugin.ipcall.a.c.VA(localk.field_status));
      break label701;
      label901:
      if (!Util.isNullOrNil(paramViewGroup.field_contactId)) {
        this.DTG.d(paramViewGroup.field_contactId, paramView);
      } else if (!Util.isNullOrNil(paramViewGroup.field_wechatUsername)) {
        this.DTG.f(paramViewGroup.field_wechatUsername, paramView);
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
    this.DXe = m.eJZ();
    this.DTH.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25869);
  }
  
  final class a
  {
    TextView DTO;
    LinearLayout DTP;
    TextView DTQ;
    TextView DTR;
    TextView DTS;
    TextView DTT;
    ImageView DTU;
    View DTV;
    View DTW;
    View DTX;
    ImageView DTY;
    ImageView jiu;
    TextView mUy;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.h
 * JD-Core Version:    0.7.0.1
 */