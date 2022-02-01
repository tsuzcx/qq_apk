package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.CardWidgetCommon";
  protected TextView fUk;
  private boolean ogU = false;
  protected TextView omC;
  protected TextView omD;
  protected Button omE;
  protected LinearLayout omF;
  protected TextView omG;
  protected ImageView omH;
  protected View omI;
  protected ImageView omJ;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bUg()
  {
    AppMethodBeat.i(113895);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.omF.getLayoutParams();
    if (this.nTp.bON())
    {
      this.omB.setVisibility(0);
      this.omH.setVisibility(8);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    for (;;)
    {
      this.omF.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113895);
      return;
      if ((this.nTp.bOO()) && (this.ogU))
      {
        this.omB.setVisibility(8);
        this.omH.setVisibility(8);
        localLayoutParams.topMargin = 0;
      }
      else if (this.nTp.bOO())
      {
        this.omB.setVisibility(0);
        this.omH.setVisibility(8);
        localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
      }
    }
  }
  
  private void bUh()
  {
    AppMethodBeat.i(113897);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.omE.getLayoutParams();
    if ((this.nTp.bPj().Ein != null) && (!TextUtils.isEmpty(this.nTp.bPj().Ein.nUt))) {
      localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
    }
    for (;;)
    {
      this.omE.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(113897);
      return;
      if ((this.nTp.bPj().Eio != null) && (!TextUtils.isEmpty(this.nTp.bPj().Eio.nUs))) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else if ((this.nTp.bPi().Ekq != null) && (this.nTp.bPi().Ekq.size() > 0)) {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165516);
      } else {
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165483);
      }
    }
  }
  
  public final void Ah(int paramInt)
  {
    AppMethodBeat.i(113896);
    this.omF.setBackgroundResource(paramInt);
    this.omH.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.omF.getLayoutParams();
      if (this.nTp.bON())
      {
        this.omB.setVisibility(8);
        localLayoutParams.topMargin = 0;
        this.omH.setVisibility(0);
        int i = this.mContext.getResources().getDimensionPixelSize(2131165955);
        n.a(this.omH, this.nTp.bPi().hhs, i, 2131233400, false);
        this.omF.setLayoutParams(localLayoutParams);
        this.omF.invalidate();
        label122:
        bUh();
        localLayoutParams = (RelativeLayout.LayoutParams)this.omI.getLayoutParams();
        if (paramInt != 0) {
          break label222;
        }
        localLayoutParams.leftMargin = 0;
      }
    }
    for (localLayoutParams.rightMargin = 0;; localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131165198))
    {
      this.omI.setLayoutParams(localLayoutParams);
      this.omI.invalidate();
      this.omA.invalidate();
      AppMethodBeat.o(113896);
      return;
      if ((!this.nTp.bOO()) || (!this.ogU)) {
        break;
      }
      this.omB.setVisibility(8);
      localLayoutParams.topMargin = 0;
      break;
      bUg();
      break label122;
      label222:
      localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131165198);
    }
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113899);
    if (this.omE != null)
    {
      yg localyg = this.nTp.bPj().Eio;
      if ((localyg != null) && (!TextUtils.isEmpty(localyg.title)) && (localyg.Els != 0L) && (this.nTp.bPe()))
      {
        this.omE.setClickable(false);
        this.omE.setVisibility(0);
        this.omJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((this.nTp.bPj().Ein != null) && (!TextUtils.isEmpty(this.nTp.bPj().Ein.title)) && (!TextUtils.isEmpty(this.nTp.bPj().Ein.url)) && (this.nTp.bPe()))
      {
        this.omE.setVisibility(0);
        this.omE.setEnabled(true);
        if ((!TextUtils.isEmpty(this.nTp.bPj().code)) && (this.nTp.bPj().Eif != 0))
        {
          this.omJ.setVisibility(0);
          AppMethodBeat.o(113899);
          return;
        }
        this.omJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(this.nTp.bPj().code)) && (this.nTp.bPe()))
      {
        this.omE.setVisibility(0);
        this.omE.setEnabled(paramBoolean2);
        this.omJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      if ((paramBoolean1) && (!this.nTp.bPe()))
      {
        this.omE.setVisibility(0);
        this.omE.setEnabled(false);
        this.omJ.setVisibility(8);
        AppMethodBeat.o(113899);
        return;
      }
      this.omE.setVisibility(8);
      this.omJ.setVisibility(8);
    }
    AppMethodBeat.o(113899);
  }
  
  public final void bRY()
  {
    AppMethodBeat.i(113900);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.omF.getLayoutParams();
    if (this.nTp.bOO())
    {
      this.omB.setVisibility(0);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131165961);
    }
    this.omF.setLayoutParams(localLayoutParams);
    this.omF.invalidate();
    AppMethodBeat.o(113900);
  }
  
  protected final void bUd()
  {
    AppMethodBeat.i(113893);
    this.fUk = ((TextView)this.omA.findViewById(2131297911));
    this.omC = ((TextView)this.omA.findViewById(2131297903));
    this.omD = ((TextView)this.omA.findViewById(2131297734));
    this.omE = ((Button)this.omA.findViewById(2131297769));
    this.omF = ((LinearLayout)this.omA.findViewById(2131306991));
    this.omH = ((ImageView)this.omF.findViewById(2131296874));
    this.omI = this.omA.findViewById(2131297740);
    this.omJ = ((ImageView)this.omA.findViewById(2131297761));
    this.omG = ((TextView)this.omA.findViewById(2131297867));
    AppMethodBeat.o(113893);
  }
  
  protected final void bUe()
  {
    AppMethodBeat.i(113894);
    yg localyg1;
    Object localObject1;
    if ((this.nTp.bPi().Ekq != null) && (this.nTp.bPi().Ekq.size() > 0))
    {
      localyg1 = (yg)this.nTp.bPi().Ekq.get(0);
      if (!bs.isNullOrNil(localyg1.title)) {
        this.fUk.setText(localyg1.title);
      }
      if (!bs.isNullOrNil(localyg1.nUs))
      {
        this.omC.setText(localyg1.nUs);
        this.omC.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)this.omC.getLayoutParams();
        if (bs.isNullOrNil(localyg1.nUt)) {
          break label245;
        }
        this.omD.setText(localyg1.nUt);
        this.omD.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        label154:
        this.omC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.omC.invalidate();
      }
    }
    else
    {
      if ((this.omE != null) && (this.omJ != null)) {
        break label273;
      }
      ac.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
    }
    label1288:
    for (;;)
    {
      bUg();
      this.omF.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131231516));
      bUh();
      this.omA.invalidate();
      AppMethodBeat.o(113894);
      return;
      this.omC.setVisibility(8);
      break;
      label245:
      this.omD.setVisibility(8);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131165483);
      break label154;
      label273:
      if (this.nTp.bPj() == null)
      {
        ac.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
        this.omE.setVisibility(8);
        this.omJ.setVisibility(8);
      }
      else
      {
        if (this.nTp.bPj().Ein != null)
        {
          ac.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.nTp.bPj().Ein.title);
          ac.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.nTp.bPj().Ein.url);
          ac.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.nTp.bPj().Ein.nUt);
        }
        localyg1 = this.nTp.bPj().Eio;
        if (localyg1 != null)
        {
          ac.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + localyg1.title);
          ac.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + localyg1.Els);
          ac.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + localyg1.nUt);
        }
        Object localObject2 = this.nTp.bPi().EkI;
        localObject1 = (LinearLayout)this.omF.findViewById(2131297782);
        if ((localObject2 != null) && (!bs.gY(((dny)localObject2).FVE)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((LinearLayout)localObject1).removeAllViews();
          localObject2 = ((dny)localObject2).FVE.iterator();
        }
        while (((Iterator)localObject2).hasNext())
        {
          yg localyg2 = (yg)((Iterator)localObject2).next();
          View localView = LayoutInflater.from(this.mContext).inflate(2131493269, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131297785);
          TextView localTextView2 = (TextView)localView.findViewById(2131297781);
          localTextView1.setText(localyg2.title);
          localTextView2.setText(localyg2.nUs);
          ((LinearLayout)localObject1).addView(localView);
          continue;
          ((LinearLayout)localObject1).setVisibility(8);
        }
        if ((localyg1 != null) && (!TextUtils.isEmpty(localyg1.title)) && (localyg1.Els != 0L) && (this.nTp.bPe()))
        {
          this.omE.setClickable(false);
          this.omE.setVisibility(0);
          this.omE.setTextColor(this.mContext.getResources().getColor(2131101185));
          this.omE.setText(localyg1.title);
          if ((localyg1 != null) && (!TextUtils.isEmpty(localyg1.nUs)))
          {
            this.omG.setText(localyg1.nUs);
            this.omG.setVisibility(0);
          }
          for (;;)
          {
            this.omJ.setVisibility(8);
            if ((localyg1.Els & 0x2) <= 0L) {
              break label890;
            }
            this.omE.setBackgroundDrawable(l.O(this.mContext, l.cG(this.nTp.bPi().hiu, 150)));
            this.omG.setTextColor(l.Vy(this.nTp.bPi().hiu));
            break;
            this.omG.setVisibility(8);
          }
          label890:
          if ((localyg1.Els & 0x4) > 0L)
          {
            this.omE.setBackgroundDrawable(l.O(this.mContext, this.mContext.getResources().getColor(2131100540)));
            this.omG.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
          else
          {
            this.omE.setBackgroundDrawable(l.O(this.mContext, l.Vy(this.nTp.bPi().hiu)));
            this.omG.setTextColor(this.mContext.getResources().getColor(2131100707));
          }
        }
        else if ((this.nTp.bPj().Ein != null) && (!TextUtils.isEmpty(this.nTp.bPj().Ein.title)) && (!TextUtils.isEmpty(this.nTp.bPj().Ein.url)) && (this.nTp.bPe()))
        {
          this.omE.setClickable(true);
          this.omE.setVisibility(0);
          this.omE.setBackgroundDrawable(l.O(this.mContext, l.Vy(this.nTp.bPi().hiu)));
          this.omE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.omE.setText(this.nTp.bPj().Ein.title);
          if ((this.nTp.bPj().Ein != null) && (!TextUtils.isEmpty(this.nTp.bPj().Ein.nUt)))
          {
            this.omG.setTextColor(this.mContext.getResources().getColor(2131100707));
            this.omG.setText(this.nTp.bPj().Ein.nUt);
            this.omG.setVisibility(0);
          }
          for (;;)
          {
            if (TextUtils.isEmpty(this.nTp.bPj().code)) {
              break label1288;
            }
            this.omJ.setVisibility(0);
            break;
            this.omG.setVisibility(8);
          }
          this.omJ.setVisibility(8);
        }
        else if ((!TextUtils.isEmpty(this.nTp.bPj().code)) && (this.nTp.bPe()))
        {
          ac.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
          this.omJ.setVisibility(8);
          this.omG.setVisibility(8);
          this.omE.setClickable(true);
          this.omE.setVisibility(0);
          this.omE.setBackgroundDrawable(l.O(this.mContext, l.Vy(this.nTp.bPi().hiu)));
          this.omE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
          this.omE.setText(2131757006);
        }
        else if (!this.nTp.bPe())
        {
          ac.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.nTp.bPj().status);
          this.omJ.setVisibility(8);
          this.omG.setVisibility(8);
          this.omE.setClickable(true);
          this.omE.setVisibility(0);
          this.omE.setTextColor(this.mContext.getResources().getColor(2131100469));
          this.omE.setBackgroundDrawable(l.O(this.mContext, this.mContext.getResources().getColor(2131100081)));
          if (!TextUtils.isEmpty(this.nTp.bPi().EkN)) {
            this.omE.setText(this.nTp.bPi().EkN);
          } else {
            n.h(this.omE, this.nTp.bPj().status);
          }
        }
        else
        {
          ac.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
          this.omE.setVisibility(8);
          this.omG.setVisibility(8);
          this.omJ.setVisibility(8);
        }
      }
    }
  }
  
  public final void jr(boolean paramBoolean)
  {
    AppMethodBeat.i(113901);
    this.ogU = paramBoolean;
    if (paramBoolean)
    {
      this.omI.setVisibility(0);
      AppMethodBeat.o(113901);
      return;
    }
    this.omI.setVisibility(8);
    AppMethodBeat.o(113901);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113898);
    super.setOnClickListener(paramOnClickListener);
    if (this.omE != null) {
      this.omE.setOnClickListener(paramOnClickListener);
    }
    if (this.omJ != null) {
      this.omJ.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(113898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.b
 * JD-Core Version:    0.7.0.1
 */