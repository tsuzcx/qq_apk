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
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameMessageListUserIconView
  extends LinearLayout
{
  private p ITc;
  private f<String, Bitmap> ITd;
  private Context mContext;
  
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
  
  private void init()
  {
    AppMethodBeat.i(42290);
    if (this.ITc == null) {
      this.ITc = new p(this.mContext);
    }
    AppMethodBeat.o(42290);
  }
  
  private void n(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42294);
    paramImageView = e.fIb().r(paramImageView, paramString);
    if (paramImageView != null) {
      this.ITd.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42294);
  }
  
  private void o(ImageView paramImageView, final String paramString)
  {
    AppMethodBeat.i(42293);
    e.a.a locala = new e.a.a();
    locala.oKn = false;
    e.fIb().a(paramImageView, paramString, locala.fIc(), new e.b()
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
  
  public final void a(o paramo, LinkedList<o.l> paramLinkedList, f<String, Bitmap> paramf)
  {
    AppMethodBeat.i(42292);
    if ((paramo == null) || (Util.isNullOrNil(paramLinkedList)))
    {
      setVisibility(8);
      AppMethodBeat.o(42292);
      return;
    }
    this.ITd = paramf;
    setVisibility(0);
    int i = this.mContext.getResources().getDimensionPixelSize(h.c.HTk);
    int j = this.mContext.getResources().getDimensionPixelSize(h.c.BasicPaddingSize);
    paramf = new LinearLayout.LayoutParams(i, i);
    paramf.rightMargin = j;
    Object localObject;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject = new ImageView(this.mContext);
      ((ImageView)localObject).setLayoutParams(paramf);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setOnClickListener(this.ITc);
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
        localObject = (o.l)paramLinkedList.get(i);
        if (!Util.isNullOrNil(((o.l)localObject).IED))
        {
          str = ((o.l)localObject).IED;
          if (this.ITd.check(str))
          {
            localBitmap = (Bitmap)this.ITd.get(str);
            if ((localBitmap == null) || (localBitmap.isRecycled()))
            {
              o(paramf, str);
              label257:
              if (Util.isNullOrNil(((o.l)localObject).DUN)) {
                break label416;
              }
              paramf.setTag(new p.a(paramo, ((o.l)localObject).DUN, 6));
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
        break label257;
        o(paramf, str);
        break label257;
        str = ((o.l)localObject).userName;
        if (Util.isNullOrNil(str))
        {
          a.b.g(paramf, str);
          break label257;
        }
        if (!this.ITd.check(str))
        {
          n(paramf, str);
          break label257;
        }
        localBitmap = (Bitmap)this.ITd.get(str);
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          n(paramf, str);
          break label257;
        }
        paramf.setImageBitmap(localBitmap);
        break label257;
        label416:
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
    if (this.ITc != null)
    {
      this.ITc.IFc = paramInt;
      AppMethodBeat.o(42291);
      return;
    }
    this.ITc = new p(this.mContext, paramInt);
    AppMethodBeat.o(42291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageListUserIconView
 * JD-Core Version:    0.7.0.1
 */