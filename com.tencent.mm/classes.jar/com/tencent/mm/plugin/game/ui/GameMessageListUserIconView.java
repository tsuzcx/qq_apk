package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public class GameMessageListUserIconView
  extends LinearLayout
{
  private p ldy;
  private f<String, Bitmap> ldz;
  private Context mContext;
  
  public GameMessageListUserIconView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public GameMessageListUserIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private void d(ImageView paramImageView, String paramString)
  {
    paramImageView = e.baw().h(paramImageView, paramString);
    if (paramImageView != null) {
      this.ldz.put(paramString, paramImageView);
    }
  }
  
  private void f(ImageView paramImageView, String paramString)
  {
    e.a.a locala = new e.a.a();
    locala.erd = false;
    e.baw().a(paramImageView, paramString, locala.bax(), new GameMessageListUserIconView.1(this, paramString));
  }
  
  private void init()
  {
    if (this.ldy == null) {
      this.ldy = new p(this.mContext);
    }
  }
  
  public final void a(o paramo, LinkedList<o.h> paramLinkedList, f<String, Bitmap> paramf)
  {
    if ((paramo == null) || (bk.dk(paramLinkedList)))
    {
      setVisibility(8);
      return;
    }
    this.ldz = paramf;
    setVisibility(0);
    int i = this.mContext.getResources().getDimensionPixelSize(g.c.GameUserIconSize);
    int j = this.mContext.getResources().getDimensionPixelSize(g.c.BasicPaddingSize);
    paramf = new LinearLayout.LayoutParams(i, i);
    paramf.rightMargin = j;
    Object localObject;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject = new ImageView(this.mContext);
      ((ImageView)localObject).setLayoutParams(paramf);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setOnClickListener(this.ldy);
      addView((View)localObject);
    }
    i = 0;
    label135:
    String str;
    Bitmap localBitmap;
    if (i < getChildCount())
    {
      paramf = (ImageView)getChildAt(i);
      if (i >= paramLinkedList.size()) {
        break label406;
      }
      paramf.setVisibility(0);
      localObject = (o.h)paramLinkedList.get(i);
      if (bk.bl(((o.h)localObject).kQb)) {
        break label306;
      }
      str = ((o.h)localObject).kQb;
      if (!this.ldz.aC(str)) {
        break label296;
      }
      localBitmap = (Bitmap)this.ldz.get(str);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label287;
      }
      f(paramf, str);
      label243:
      if (bk.bl(((o.h)localObject).kQe)) {
        break label398;
      }
      paramf.setTag(new p.a(paramo, ((o.h)localObject).kQe, 6));
      paramf.setEnabled(true);
    }
    for (;;)
    {
      i += 1;
      break label135;
      break;
      label287:
      paramf.setImageBitmap(localBitmap);
      break label243;
      label296:
      f(paramf, str);
      break label243;
      label306:
      str = ((o.h)localObject).userName;
      if (bk.bl(str))
      {
        a.b.a(paramf, str);
        break label243;
      }
      if (!this.ldz.aC(str))
      {
        d(paramf, str);
        break label243;
      }
      localBitmap = (Bitmap)this.ldz.get(str);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        d(paramf, str);
        break label243;
      }
      paramf.setImageBitmap(localBitmap);
      break label243;
      label398:
      paramf.setEnabled(false);
      continue;
      label406:
      paramf.setVisibility(8);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    init();
  }
  
  public void setSourceScene(int paramInt)
  {
    if (this.ldy != null)
    {
      this.ldy.kQh = paramInt;
      return;
    }
    this.ldy = new p(this.mContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageListUserIconView
 * JD-Core Version:    0.7.0.1
 */