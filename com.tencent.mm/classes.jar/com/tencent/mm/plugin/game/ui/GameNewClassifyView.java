package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.protobuf.eg;
import com.tencent.mm.plugin.game.protobuf.eh;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private int CKU;
  private LayoutInflater mYa;
  private LinearLayout wSF;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(eh parameh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42315);
    if ((parameh == null) || (Util.isNullOrNil(parameh.COK)))
    {
      setVisibility(8);
      AppMethodBeat.o(42315);
      return;
    }
    this.CKU = paramInt2;
    if (this.mYa == null) {
      this.mYa = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    this.wSF.removeAllViews();
    LinearLayout localLinearLayout;
    while (this.wSF.getChildCount() < parameh.COK.size())
    {
      localLinearLayout = (LinearLayout)this.mYa.inflate(g.f.CnT, this, false);
      localLinearLayout.setOnClickListener(this);
      this.wSF.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
    }
    paramInt2 = 0;
    if (paramInt2 < this.wSF.getChildCount())
    {
      if (paramInt2 < parameh.COK.size()) {
        this.wSF.getChildAt(paramInt2).setVisibility(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        this.wSF.getChildAt(paramInt2).setVisibility(8);
      }
    }
    paramInt2 = 0;
    while (paramInt2 < parameh.COK.size())
    {
      localLinearLayout = (LinearLayout)this.wSF.getChildAt(paramInt2);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(g.e.ChY);
      TextView localTextView = (TextView)localLinearLayout.findViewById(g.e.ChZ);
      e.eAa().o(localImageView, ((eg)parameh.COK.get(paramInt2)).CNj);
      localTextView.setText(((eg)parameh.COK.get(paramInt2)).fwr);
      localLinearLayout.setTag(new a(((eg)parameh.COK.get(paramInt2)).CMD, paramInt2 + 1, ((eg)parameh.COK.get(paramInt2)).CNA));
      paramInt2 += 1;
    }
    setVisibility(0);
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1019, 0, null, this.CKU, null);
    }
    AppMethodBeat.o(42315);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42316);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42316);
      return;
    }
    paramView = (a)paramView.getTag();
    if (!Util.isNullOrNil(paramView.url))
    {
      c.aY(getContext(), paramView.url);
      g.a(getContext(), 10, 1019, paramView.position, 7, null, this.CKU, com.tencent.mm.plugin.game.c.a.Md(paramView.extInfo));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42316);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42314);
    super.onFinishInflate();
    this.mYa = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.wSF = ((LinearLayout)findViewById(g.e.CjO));
    AppMethodBeat.o(42314);
  }
  
  static final class a
  {
    public String extInfo;
    public int position;
    public String url;
    
    public a(String paramString1, int paramInt, String paramString2)
    {
      this.url = paramString1;
      this.position = paramInt;
      this.extInfo = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewClassifyView
 * JD-Core Version:    0.7.0.1
 */