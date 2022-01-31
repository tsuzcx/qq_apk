package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x
  extends i
{
  MMActivity jpX;
  private boolean kBF;
  private View kBG;
  private View kBH;
  private ImageView kBI;
  private TextView kBJ;
  private TextView kBK;
  private ImageView kBL;
  View kBM;
  private LinearLayout kBN;
  private View.OnClickListener kBO;
  
  public x()
  {
    AppMethodBeat.i(88785);
    this.kBF = false;
    this.kBO = new x.1(this);
    AppMethodBeat.o(88785);
  }
  
  public final void bfq()
  {
    AppMethodBeat.i(88788);
    this.kBG.setVisibility(8);
    AppMethodBeat.o(88788);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(88786);
    this.kBG = findViewById(2131822071);
    this.kBH = findViewById(2131822363);
    this.kBI = ((ImageView)findViewById(2131822365));
    this.kBJ = ((TextView)findViewById(2131822366));
    this.kBK = ((TextView)findViewById(2131822367));
    this.kBL = ((ImageView)findViewById(2131822368));
    this.kBG.setVisibility(8);
    this.kBM = findViewById(2131822369);
    this.kBN = ((LinearLayout)findViewById(2131822370));
    this.kBM.setVisibility(8);
    this.jpX = this.kBh.bdy();
    AppMethodBeat.o(88786);
  }
  
  public final void update()
  {
    AppMethodBeat.i(88787);
    Object localObject4 = this.kBh.bdv();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.HS(((com.tencent.mm.plugin.card.base.b)localObject4).bbi());
    Object localObject1 = this.kBh.bdA();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label347:
    int i;
    if (((g)localObject1).beN())
    {
      this.kBG.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.HR(((com.tencent.mm.plugin.card.base.b)localObject4).bbi()) > 1) {
        this.kBH.setOnClickListener(this.kBh.bdz());
      }
      for (;;)
      {
        localObject4 = this.kBh.bdv();
        if (!this.kBh.bdw()) {
          break;
        }
        this.kBI.setVisibility(8);
        this.kBJ.setVisibility(8);
        this.kBK.setVisibility(0);
        this.kBL.setImageResource(2130838167);
        this.kBK.setText(this.jpX.getString(2131298043));
        if (!this.kBh.bdw()) {
          break label881;
        }
        this.kBM.setVisibility(0);
        if ((this.kBN.getChildCount() != 0) || (localObject3 == null)) {
          break label751;
        }
        localObject1 = (LayoutInflater)this.jpX.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label733;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(2130970727, this.kBN, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(2131827763);
          localObject5 = (TextView)((View)localObject4).findViewById(2131824605);
          localObject6 = (TextView)((View)localObject4).findViewById(2131827766);
          if (!TextUtils.isEmpty(((r)localObject3).kqi))
          {
            a.b.c((ImageView)localObject7, ((r)localObject3).kqi);
            localObject7 = l.ID(((r)localObject3).kqi);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(j.f(this.jpX, (CharSequence)localObject7, this.jpX.getResources().getDimensionPixelOffset(2131427862)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).kqj);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.kBO);
          localObject5 = (ImageView)((View)localObject4).findViewById(2131827765);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131827764);
          if (!((r)localObject3).kql) {
            break label716;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label434:
          this.kBN.addView((View)localObject4);
        }
        this.kBL.setVisibility(8);
        this.kBM.setVisibility(8);
        this.kBN.removeAllViews();
        this.kBh.bdx();
      }
      this.kBI.setVisibility(0);
      this.kBJ.setVisibility(0);
      this.kBK.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.HR(((com.tencent.mm.plugin.card.base.b)localObject4).bbi()) <= 1)
      {
        this.kBL.setVisibility(8);
        label531:
        if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
          break label1070;
        }
        i = 0;
        label546:
        if (i >= ((ArrayList)localObject3).size()) {
          break label1070;
        }
        localObject1 = (r)((ArrayList)localObject3).get(i);
        if (!((r)localObject1).kql) {
          break label698;
        }
      }
    }
    label1065:
    label1070:
    for (localObject1 = ((r)localObject1).kqi;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bbj())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).bbj();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      a.b.c(this.kBI, (String)localObject2);
      localObject1 = this.jpX.getString(2131298048, new Object[] { l.ID((String)localObject2) });
      this.kBJ.setText(j.f(this.jpX, (CharSequence)localObject1, this.jpX.getResources().getDimensionPixelOffset(2131427809)));
      break;
      this.kBL.setVisibility(0);
      this.kBL.setImageResource(2130838166);
      break label531;
      label698:
      i += 1;
      break label546;
      ((TextView)localObject5).setText("");
      break label347;
      label716:
      ((ImageView)localObject5).setVisibility(8);
      ((ImageView)localObject6).setVisibility(8);
      break label434;
      label733:
      this.kBN.invalidate();
      this.kBF = true;
      AppMethodBeat.o(88787);
      return;
      label751:
      i = 0;
      if (i < this.kBN.getChildCount())
      {
        localObject2 = this.kBN.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.kBN.getChildCount())) {
          break label1065;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(2131827765);
        localObject2 = (ImageView)((View)localObject2).findViewById(2131827764);
        if ((localObject1 != null) && (((r)localObject1).kql))
        {
          ((ImageView)localObject4).setVisibility(0);
          ((ImageView)localObject2).setVisibility(0);
        }
        for (;;)
        {
          i += 1;
          break;
          ((ImageView)localObject4).setVisibility(8);
          ((ImageView)localObject2).setVisibility(8);
        }
        this.kBN.invalidate();
        break;
        label881:
        this.kBM.setVisibility(8);
        this.kBN.removeAllViews();
        break;
        if (!((g)localObject1).beN())
        {
          this.kBG.setVisibility(0);
          this.kBI.setVisibility(0);
          this.kBJ.setVisibility(0);
          this.kBK.setVisibility(8);
          this.kBL.setVisibility(8);
          localObject2 = "";
          localObject1 = localObject2;
          if (TextUtils.isEmpty(""))
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).bbj())) {
              localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).bbj();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a.b.c(this.kBI, (String)localObject1);
            localObject1 = this.jpX.getString(2131298048, new Object[] { l.ID((String)localObject1) });
            this.kBJ.setText(j.f(this.jpX, (CharSequence)localObject1, this.jpX.getResources().getDimensionPixelOffset(2131427809)));
          }
          this.kBF = true;
        }
        AppMethodBeat.o(88787);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x
 * JD-Core Version:    0.7.0.1
 */