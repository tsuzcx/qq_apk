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
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends com.tencent.mm.ui.s<com.tencent.mm.plugin.masssend.a.a>
{
  private static short znL = 1;
  private static short znM = 2;
  private static short znN = 3;
  private static short znO = 4;
  int gAZ;
  private MMActivity gte;
  private LayoutInflater kgB;
  int qdp;
  private short[] znP;
  private List<String> znQ;
  String znR;
  c.e znS;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    AppMethodBeat.i(26409);
    this.znR = "";
    this.gte = ((MMActivity)paramContext);
    this.znQ = new LinkedList();
    this.qdp = 10;
    this.gAZ = this.qdp;
    this.kgB = com.tencent.mm.ui.aa.jQ(paramContext);
    AppMethodBeat.o(26409);
  }
  
  private static int Qi(int paramInt)
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
  
  private void ehR()
  {
    AppMethodBeat.i(26414);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(26414);
      return;
    }
    this.znP = new short[i];
    AppMethodBeat.o(26414);
  }
  
  public final void aDP(String paramString)
  {
    AppMethodBeat.i(26413);
    this.znR = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(26413);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(26411);
    this.gAZ = h.ehF().ehA();
    setCursor(h.ehF().Pf(this.qdp));
    ehR();
    super.notifyDataSetChanged();
    AppMethodBeat.o(26411);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(26410);
    anp();
    AppMethodBeat.o(26410);
  }
  
  public final boolean cwg()
  {
    return this.qdp >= this.gAZ;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26412);
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
        this.znP[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.znP[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
          break label530;
        }
        paramInt = 1;
        switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
        {
        default: 
          paramViewGroup = paramView;
          label174:
          paramView = (f)paramViewGroup.getTag();
          label260:
          if (paramInt != 0)
          {
            paramView.pwO.setVisibility(0);
            paramView.pwO.setText(f.c(this.gte, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (f)paramViewGroup.getTag();
              ((f)localObject2).znU.setText(this.gte.getResources().getQuantityString(2131623955, ((com.tencent.mm.plugin.masssend.a.a)localObject1).znn, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).znn) }));
              if (this.znQ.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).ehw()))
              {
                ((f)localObject2).znV.setSingleLine(false);
                ((f)localObject2).znV.setEllipsize(null);
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
      Object localObject3 = ((f)localObject2).znV;
      MMActivity localMMActivity = this.gte;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).ehz() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).ehz().equals(""))) {
        break label1755;
      }
      paramView = "";
      ((TextView)localObject3).setText(l.b(localMMActivity, paramView, ((f)localObject2).znV.getTextSize()));
      paramInt = (int)((f)localObject2).znV.getTextSize();
      paramView = ((f)localObject2).znV.getText().toString();
      com.tencent.mm.cb.a.fromDPToPix(this.gte, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((f)localObject2).znY.setOnClickListener(new c.b(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).ehw()));
      AppMethodBeat.o(26412);
      return paramViewGroup;
      i = 0;
      break;
      label501:
      j = 0;
      break label82;
      label507:
      this.znP[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.znP[paramInt] = 1;
      break label102;
      label530:
      paramInt = 0;
      break label126;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).zob == znL) {
          break label174;
        }
      }
      paramViewGroup = this.kgB.inflate(2131495466, null);
      ((f)localObject2).znU = ((TextView)paramViewGroup.findViewById(2131304518));
      ((f)localObject2).znV = ((TextView)paramViewGroup.findViewById(2131304521));
      ((f)localObject2).znW = ((TextView)paramViewGroup.findViewById(2131304522));
      ((f)localObject2).znY = ((TextView)paramViewGroup.findViewById(2131304516));
      ((f)localObject2).pwO = ((TextView)paramViewGroup.findViewById(2131304527));
      ((f)localObject2).zoa = paramViewGroup.findViewById(2131304517);
      ((f)localObject2).zob = znL;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).zob == znO) {
          break label174;
        }
      }
      paramViewGroup = this.kgB.inflate(2131495468, null);
      ((f)localObject2).znU = ((TextView)paramViewGroup.findViewById(2131304518));
      ((f)localObject2).znV = ((TextView)paramViewGroup.findViewById(2131304521));
      ((f)localObject2).znX = ((TextView)paramViewGroup.findViewById(2131304519));
      ((f)localObject2).znW = ((TextView)paramViewGroup.findViewById(2131304526));
      ((f)localObject2).znZ = ((AnimImageView)paramViewGroup.findViewById(2131304525));
      ((f)localObject2).znY = ((TextView)paramViewGroup.findViewById(2131304516));
      ((f)localObject2).pwO = ((TextView)paramViewGroup.findViewById(2131304527));
      ((f)localObject2).zoa = paramViewGroup.findViewById(2131304517);
      ((f)localObject2).zob = znO;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).zob == znM) {
          break label174;
        }
      }
      paramViewGroup = this.kgB.inflate(2131495465, null);
      ((f)localObject2).znU = ((TextView)paramViewGroup.findViewById(2131304518));
      ((f)localObject2).znV = ((TextView)paramViewGroup.findViewById(2131304521));
      ((f)localObject2).mEx = ((ImageView)paramViewGroup.findViewById(2131304523));
      ((f)localObject2).znY = ((TextView)paramViewGroup.findViewById(2131304516));
      ((f)localObject2).pwO = ((TextView)paramViewGroup.findViewById(2131304527));
      ((f)localObject2).zoa = paramViewGroup.findViewById(2131304517);
      ((f)localObject2).zob = znM;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).zob == znN) {
          break label174;
        }
      }
      paramViewGroup = this.kgB.inflate(2131495467, null);
      ((f)localObject2).znU = ((TextView)paramViewGroup.findViewById(2131304518));
      ((f)localObject2).znV = ((TextView)paramViewGroup.findViewById(2131304521));
      ((f)localObject2).mEx = ((ImageView)paramViewGroup.findViewById(2131304523));
      ((f)localObject2).znX = ((TextView)paramViewGroup.findViewById(2131304524));
      ((f)localObject2).znY = ((TextView)paramViewGroup.findViewById(2131304516));
      ((f)localObject2).pwO = ((TextView)paramViewGroup.findViewById(2131304527));
      ((f)localObject2).zoa = paramViewGroup.findViewById(2131304517);
      ((f)localObject2).zob = znN;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.pwO.setVisibility(8);
      break label214;
      paramView = (f)paramViewGroup.getTag();
      paramView.znW.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).ehx());
      l.p(paramView.znW, 1);
      break label260;
      paramView = (f)paramViewGroup.getTag();
      float f = com.tencent.mm.modelvoice.s.AO(((com.tencent.mm.plugin.masssend.a.a)localObject1).zno);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).ehw().equals(this.znR))
      {
        paramView.znZ.setVisibility(0);
        paramView.znZ.bWT();
        paramView.znW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.znX.setText(this.gte.getString(2131760887, new Object[] { Integer.valueOf((int)f) }));
        paramView.znW.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.znW.getContext(), Qi((int)f)));
        paramView.znZ.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.znW.getContext(), Qi((int)f)));
        paramView.znW.setOnClickListener(new c.d(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).ehw()));
        break;
        paramView.znZ.setVisibility(8);
        paramView.znZ.cEA();
        paramView.znW.setCompoundDrawablesWithIntrinsicBounds(null, null, this.gte.getResources().getDrawable(2131689942), null);
      }
      paramView = (f)paramViewGroup.getTag();
      bg.aVF();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        h.ehF();
        localObject2 = b.aDK(((com.tencent.mm.plugin.masssend.a.a)localObject1).ehx());
        if (localObject2 != null) {
          paramView.mEx.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.mEx.setOnClickListener(new c.a(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).ehx(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).znr));
        break;
        h.ehF();
        localObject2 = b.h(((com.tencent.mm.plugin.masssend.a.a)localObject1).ehy(), com.tencent.mm.cb.a.getDensity(paramView.mEx.getContext()));
        paramView.mEx.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.mEx.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131234279));
      }
      paramView = (f)paramViewGroup.getTag();
      o.bhj();
      localObject2 = t.Qx(((com.tencent.mm.plugin.masssend.a.a)localObject1).ehx());
      localObject2 = q.bcR().a((String)localObject2, com.tencent.mm.cb.a.getDensity(paramView.mEx.getContext()), -1);
      if (localObject2 == null)
      {
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.mEx.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131691699));
        }
      }
      for (;;)
      {
        paramView.mEx.setOnClickListener(new c.c(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).ehx(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).djh, ((com.tencent.mm.plugin.masssend.a.a)localObject1).zno));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1706;
        }
        paramView.znX.setVisibility(8);
        break;
        paramView.mEx.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131100580));
        continue;
        paramView.mEx.setImageBitmap((Bitmap)localObject2);
      }
      label1706:
      paramView.znX.setVisibility(0);
      paramView.znX.setText(Util.formatSecToMin(((com.tencent.mm.plugin.masssend.a.a)localObject1).zno));
      break label260;
      ((f)localObject2).znV.setSingleLine(true);
      ((f)localObject2).znV.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1755:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).ehz().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = Util.stringsToList((String[])localObject4);
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
        String str = com.tencent.mm.model.aa.getDisplayName((String)paramView.get(paramInt));
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
  
  static final class f
  {
    ImageView mEx;
    TextView pwO;
    TextView znU;
    TextView znV;
    TextView znW;
    TextView znX;
    TextView znY;
    AnimImageView znZ;
    View zoa;
    short zob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */