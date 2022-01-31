package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends p<com.tencent.mm.plugin.masssend.a.a>
{
  private static short oBF = 1;
  private static short oBG = 2;
  private static short oBH = 3;
  private static short oBI = 4;
  private MMActivity cmc;
  int eke;
  private LayoutInflater exe;
  int kxm;
  private short[] oBJ;
  private List<String> oBK;
  String oBL;
  c.e oBM;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    AppMethodBeat.i(22787);
    this.oBL = "";
    this.cmc = ((MMActivity)paramContext);
    this.oBK = new LinkedList();
    this.kxm = 10;
    this.eke = this.kxm;
    this.exe = w.hM(paramContext);
    AppMethodBeat.o(22787);
  }
  
  private void bPl()
  {
    AppMethodBeat.i(22792);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(22792);
      return;
    }
    this.oBJ = new short[i];
    AppMethodBeat.o(22792);
  }
  
  private static int yP(int paramInt)
  {
    if (paramInt <= 2) {
      return 100;
    }
    if (paramInt < 10) {
      return (paramInt - 2) * 8 + 100;
    }
    if (paramInt < 60) {
      return (paramInt / 10 + 7) * 8 + 100;
    }
    return 204;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(22789);
    this.eke = com.tencent.mm.plugin.masssend.a.h.bPc().bOX();
    setCursor(com.tencent.mm.plugin.masssend.a.h.bPc().xL(this.kxm));
    bPl();
    super.notifyDataSetChanged();
    AppMethodBeat.o(22789);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(22788);
    Ku();
    AppMethodBeat.o(22788);
  }
  
  public final void SG(String paramString)
  {
    AppMethodBeat.i(22791);
    this.oBL = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(22791);
  }
  
  public final boolean bem()
  {
    return this.kxm >= this.eke;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22790);
    Object localObject1 = (com.tencent.mm.plugin.masssend.a.a)getItem(paramInt);
    int i;
    int j;
    label82:
    label102:
    label126:
    Object localObject2;
    if (paramInt != 0)
    {
      long l1 = ((com.tencent.mm.plugin.masssend.a.a)getItem(paramInt - 1)).createTime;
      paramViewGroup = (com.tencent.mm.plugin.masssend.a.a)getItem(paramInt);
      long l2 = paramViewGroup.createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label501;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label507;
        }
        this.oBJ[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.oBJ[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
          break label530;
        }
        paramInt = 1;
        switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
        {
        default: 
          paramViewGroup = paramView;
          label174:
          paramView = (c.f)paramViewGroup.getTag();
          label260:
          if (paramInt != 0)
          {
            paramView.nxi.setVisibility(0);
            paramView.nxi.setText(com.tencent.mm.pluginsdk.f.h.c(this.cmc, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (c.f)paramViewGroup.getTag();
              ((c.f)localObject2).oBO.setText(this.cmc.getResources().getQuantityString(2131361809, ((com.tencent.mm.plugin.masssend.a.a)localObject1).oBf, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).oBf) }));
              if (this.oBK.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).bOT()))
              {
                ((c.f)localObject2).oBP.setSingleLine(false);
                ((c.f)localObject2).oBP.setEllipsize(null);
              }
              break;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      Object localObject3 = ((c.f)localObject2).oBP;
      MMActivity localMMActivity = this.cmc;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).bOW() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).bOW().equals(""))) {
        break label1758;
      }
      paramView = "";
      ((TextView)localObject3).setText(j.b(localMMActivity, paramView, ((c.f)localObject2).oBP.getTextSize()));
      paramInt = (int)((c.f)localObject2).oBP.getTextSize();
      paramView = ((c.f)localObject2).oBP.getText().toString();
      com.tencent.mm.cb.a.fromDPToPix(this.cmc, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((c.f)localObject2).oBS.setOnClickListener(new c.b(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bOT()));
      AppMethodBeat.o(22790);
      return paramViewGroup;
      i = 0;
      break;
      label501:
      j = 0;
      break label82;
      label507:
      this.oBJ[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.oBJ[paramInt] = 1;
      break label102;
      label530:
      paramInt = 0;
      break label126;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).oBV == oBF) {
          break label174;
        }
      }
      paramViewGroup = this.exe.inflate(2130970122, null);
      ((c.f)localObject2).oBO = ((TextView)paramViewGroup.findViewById(2131826096));
      ((c.f)localObject2).oBP = ((TextView)paramViewGroup.findViewById(2131826097));
      ((c.f)localObject2).oBQ = ((TextView)paramViewGroup.findViewById(2131826100));
      ((c.f)localObject2).oBS = ((TextView)paramViewGroup.findViewById(2131826099));
      ((c.f)localObject2).nxi = ((TextView)paramViewGroup.findViewById(2131826094));
      ((c.f)localObject2).oBU = paramViewGroup.findViewById(2131826095);
      ((c.f)localObject2).oBV = oBF;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).oBV == oBI) {
          break label174;
        }
      }
      paramViewGroup = this.exe.inflate(2130970124, null);
      ((c.f)localObject2).oBO = ((TextView)paramViewGroup.findViewById(2131826096));
      ((c.f)localObject2).oBP = ((TextView)paramViewGroup.findViewById(2131826097));
      ((c.f)localObject2).oBR = ((TextView)paramViewGroup.findViewById(2131826103));
      ((c.f)localObject2).oBQ = ((TextView)paramViewGroup.findViewById(2131826104));
      ((c.f)localObject2).oBT = ((AnimImageView)paramViewGroup.findViewById(2131826105));
      ((c.f)localObject2).oBS = ((TextView)paramViewGroup.findViewById(2131826099));
      ((c.f)localObject2).nxi = ((TextView)paramViewGroup.findViewById(2131826094));
      ((c.f)localObject2).oBU = paramViewGroup.findViewById(2131826095);
      ((c.f)localObject2).oBV = oBI;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).oBV == oBG) {
          break label174;
        }
      }
      paramViewGroup = this.exe.inflate(2130970121, null);
      ((c.f)localObject2).oBO = ((TextView)paramViewGroup.findViewById(2131826096));
      ((c.f)localObject2).oBP = ((TextView)paramViewGroup.findViewById(2131826097));
      ((c.f)localObject2).mwF = ((ImageView)paramViewGroup.findViewById(2131826098));
      ((c.f)localObject2).oBS = ((TextView)paramViewGroup.findViewById(2131826099));
      ((c.f)localObject2).nxi = ((TextView)paramViewGroup.findViewById(2131826094));
      ((c.f)localObject2).oBU = paramViewGroup.findViewById(2131826095);
      ((c.f)localObject2).oBV = oBG;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).oBV == oBH) {
          break label174;
        }
      }
      paramViewGroup = this.exe.inflate(2130970123, null);
      ((c.f)localObject2).oBO = ((TextView)paramViewGroup.findViewById(2131826096));
      ((c.f)localObject2).oBP = ((TextView)paramViewGroup.findViewById(2131826097));
      ((c.f)localObject2).mwF = ((ImageView)paramViewGroup.findViewById(2131826098));
      ((c.f)localObject2).oBR = ((TextView)paramViewGroup.findViewById(2131826101));
      ((c.f)localObject2).oBS = ((TextView)paramViewGroup.findViewById(2131826099));
      ((c.f)localObject2).nxi = ((TextView)paramViewGroup.findViewById(2131826094));
      ((c.f)localObject2).oBU = paramViewGroup.findViewById(2131826095);
      ((c.f)localObject2).oBV = oBH;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.nxi.setVisibility(8);
      break label214;
      paramView = (c.f)paramViewGroup.getTag();
      paramView.oBQ.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).bOU());
      j.k(paramView.oBQ, 1);
      break label260;
      paramView = (c.f)paramViewGroup.getTag();
      float f = com.tencent.mm.modelvoice.s.hi(((com.tencent.mm.plugin.masssend.a.a)localObject1).oBg);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).bOT().equals(this.oBL))
      {
        paramView.oBT.setVisibility(0);
        paramView.oBT.dDA();
        paramView.oBQ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.oBR.setText(this.cmc.getString(2131300103, new Object[] { Integer.valueOf((int)f) }));
        paramView.oBQ.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.oBQ.getContext(), yP((int)f)));
        paramView.oBT.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.oBQ.getContext(), yP((int)f)));
        paramView.oBQ.setOnClickListener(new c.d(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bOT()));
        break;
        paramView.oBT.setVisibility(8);
        paramView.oBT.cgf();
        paramView.oBQ.setCompoundDrawablesWithIntrinsicBounds(null, null, this.cmc.getResources().getDrawable(2131231133), null);
      }
      paramView = (c.f)paramViewGroup.getTag();
      aw.aaz();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.plugin.masssend.a.h.bPc();
        localObject2 = b.SB(((com.tencent.mm.plugin.masssend.a.a)localObject1).bOU());
        if (localObject2 != null) {
          paramView.mwF.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.mwF.setOnClickListener(new c.a(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bOU(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).oBj));
        break;
        com.tencent.mm.plugin.masssend.a.h.bPc();
        localObject2 = b.i(((com.tencent.mm.plugin.masssend.a.a)localObject1).bOV(), com.tencent.mm.cb.a.getDensity(paramView.mwF.getContext()));
        paramView.mwF.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.mwF.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2130839821));
      }
      paramView = (c.f)paramViewGroup.getTag();
      com.tencent.mm.modelvideo.o.alE();
      localObject2 = t.vg(((com.tencent.mm.plugin.masssend.a.a)localObject1).bOU());
      localObject2 = com.tencent.mm.at.o.ahC().a((String)localObject2, com.tencent.mm.cb.a.getDensity(paramView.mwF.getContext()), this.cmc);
      if (localObject2 == null)
      {
        aw.aaz();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.mwF.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131232157));
        }
      }
      for (;;)
      {
        paramView.mwF.setOnClickListener(new c.c(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bOU(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bWt, ((com.tencent.mm.plugin.masssend.a.a)localObject1).oBg));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1709;
        }
        paramView.oBR.setVisibility(8);
        break;
        paramView.mwF.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131690155));
        continue;
        paramView.mwF.setImageBitmap((Bitmap)localObject2);
      }
      label1709:
      paramView.oBR.setVisibility(0);
      paramView.oBR.setText(bo.mH(((com.tencent.mm.plugin.masssend.a.a)localObject1).oBg));
      break label260;
      ((c.f)localObject2).oBP.setSingleLine(true);
      ((c.f)localObject2).oBP.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1758:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).bOW().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = bo.P((String[])localObject4);
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramView = "";
        break;
      }
      localObject4 = new StringBuilder();
      paramInt = 0;
      if (paramInt < paramView.size())
      {
        String str = com.tencent.mm.model.s.nE((String)paramView.get(paramInt));
        if (paramInt == paramView.size() - 1) {
          ((StringBuilder)localObject4).append(str);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          ((StringBuilder)localObject4).append(str + ", ");
        }
      }
      paramView = ((StringBuilder)localObject4).toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */