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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.f.e.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class GameMessageListUserIconView
  extends LinearLayout
{
  private Context mContext;
  private p uCD;
  private f<String, Bitmap> uCE;
  
  public GameMessageListUserIconView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(42287);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(42287);
  }
  
  public GameMessageListUserIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42288);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(42288);
  }
  
  private void i(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42294);
    paramImageView = e.ddh().n(paramImageView, paramString);
    if (paramImageView != null) {
      this.uCE.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42294);
  }
  
  private void init()
  {
    AppMethodBeat.i(42290);
    if (this.uCD == null) {
      this.uCD = new p(this.mContext);
    }
    AppMethodBeat.o(42290);
  }
  
  private void k(ImageView paramImageView, final String paramString)
  {
    AppMethodBeat.i(42293);
    e.a.a locala = new e.a.a();
    locala.igi = false;
    e.ddh().a(paramImageView, paramString, locala.ddi(), new e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(42286);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          GameMessageListUserIconView.a(GameMessageListUserIconView.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(42286);
      }
    });
    AppMethodBeat.o(42293);
  }
  
  public final void a(o paramo, LinkedList<o.k> paramLinkedList, f<String, Bitmap> paramf)
  {
    AppMethodBeat.i(42292);
    if ((paramo == null) || (bu.ht(paramLinkedList)))
    {
      setVisibility(8);
      AppMethodBeat.o(42292);
      return;
    }
    this.uCE = paramf;
    setVisibility(0);
    int i = this.mContext.getResources().getDimensionPixelSize(2131165460);
    int j = this.mContext.getResources().getDimensionPixelSize(2131165187);
    paramf = new LinearLayout.LayoutParams(i, i);
    paramf.rightMargin = j;
    Object localObject;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject = new ImageView(this.mContext);
      ((ImageView)localObject).setLayoutParams(paramf);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setOnClickListener(this.uCD);
      addView((View)localObject);
    }
    i = 0;
    if (i < getChildCount())
    {
      paramf = (ImageView)getChildAt(i);
      String str;
      Bitmap localBitmap;
      if (i < paramLinkedList.size())
      {
        paramf.setVisibility(0);
        localObject = (o.k)paramLinkedList.get(i);
        if (!bu.isNullOrNil(((o.k)localObject).unY))
        {
          str = ((o.k)localObject).unY;
          if (this.uCE.aM(str))
          {
            localBitmap = (Bitmap)this.uCE.get(str);
            if ((localBitmap == null) || (localBitmap.isRecycled()))
            {
              k(paramf, str);
              label255:
              if (bu.isNullOrNil(((o.k)localObject).uob)) {
                break label414;
              }
              paramf.setTag(new p.a(paramo, ((o.k)localObject).uob, 6));
              paramf.setEnabled(true);
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramf.setImageBitmap(localBitmap);
        break label255;
        k(paramf, str);
        break label255;
        str = ((o.k)localObject).userName;
        if (bu.isNullOrNil(str))
        {
          a.b.c(paramf, str);
          break label255;
        }
        if (!this.uCE.aM(str))
        {
          i(paramf, str);
          break label255;
        }
        localBitmap = (Bitmap)this.uCE.get(str);
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          i(paramf, str);
          break label255;
        }
        paramf.setImageBitmap(localBitmap);
        break label255;
        label414:
        paramf.setEnabled(false);
        continue;
        paramf.setVisibility(8);
      }
    }
    AppMethodBeat.o(42292);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42289);
    super.onFinishInflate();
    init();
    AppMethodBeat.o(42289);
  }
  
  public void setSourceScene(int paramInt)
  {
    AppMethodBeat.i(42291);
    if (this.uCD != null)
    {
      this.uCD.uoy = paramInt;
      AppMethodBeat.o(42291);
      return;
    }
    this.uCD = new p(this.mContext, paramInt);
    AppMethodBeat.o(42291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageListUserIconView
 * JD-Core Version:    0.7.0.1
 */