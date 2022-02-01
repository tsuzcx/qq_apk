package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends i
{
  private TextView oJk;
  private View oUS;
  private TextView oUT;
  private TextView oUU;
  
  public final void ZO(String paramString)
  {
    AppMethodBeat.i(113668);
    this.oUU.setText(paramString);
    AppMethodBeat.o(113668);
  }
  
  public final void bZG()
  {
    AppMethodBeat.i(113667);
    this.oUS.setVisibility(8);
    AppMethodBeat.o(113667);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113665);
    this.oUS = findViewById(2131296509);
    this.oUT = ((TextView)findViewById(2131296510));
    this.oJk = ((TextView)findViewById(2131304741));
    this.oUU = ((TextView)findViewById(2131297880));
    this.oUT.setOnClickListener(this.oVd.bXE());
    this.oUS.setVisibility(8);
    AppMethodBeat.o(113665);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113666);
    b localb = this.oVd.bXA();
    Object localObject1 = this.oVd.bXD();
    this.oUS.setVisibility(0);
    if (!TextUtils.isEmpty(localb.bVc().Gki))
    {
      this.oUT.setVisibility(0);
      this.oUT.setText(localb.bVc().Gki);
      if ((localb.bUI()) || ((localb.bUH()) && (localb.bUK()))) {
        this.oUT.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101182));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.oUS.findViewById(2131297895);
      if (!this.oVd.bXF().bZe()) {
        break label529;
      }
      ((View)localObject2).setVisibility(0);
      this.oUU.setText(((MMActivity)localObject1).getString(2131756980));
      this.oUU.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101182));
      int i = ((MMActivity)localObject1).getResources().getDimensionPixelOffset(2131165516);
      localObject2 = (Button)this.oUS.findViewById(2131297878);
      ShapeDrawable localShapeDrawable1 = l.f((Context)localObject1, ((MMActivity)localObject1).getResources().getColor(2131101179), i);
      ShapeDrawable localShapeDrawable2 = l.eV(((MMActivity)localObject1).getResources().getColor(2131101179), i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable2);
      localStateListDrawable.addState(new int[0], localShapeDrawable1);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      i = l.ZY(localb.bVc().hDr);
      int j = ((MMActivity)localObject1).getResources().getColor(2131101179);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      ((Button)localObject2).setOnClickListener(this.oVd.bXE());
      localObject1 = this.oUS.findViewById(2131302274);
      localObject2 = this.oUS.findViewById(2131297822);
      if (localb.bVc().Gkw != 1) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      AppMethodBeat.o(113666);
      return;
      if ((localb.bUH()) && (localb.bUJ()))
      {
        this.oUT.setTextColor(((MMActivity)localObject1).getResources().getColor(2131100082));
        this.oUS.setBackgroundColor(((MMActivity)localObject1).getResources().getColor(2131101179));
      }
      else
      {
        this.oUT.setTextColor(((MMActivity)localObject1).getResources().getColor(2131101182));
        continue;
        this.oUT.setVisibility(8);
      }
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(113666);
    return;
    label529:
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(113666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.d
 * JD-Core Version:    0.7.0.1
 */