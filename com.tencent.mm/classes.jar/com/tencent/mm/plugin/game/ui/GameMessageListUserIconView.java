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
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameMessageListUserIconView
  extends LinearLayout
{
  private Context mContext;
  private o nBt;
  private f<String, Bitmap> nBu;
  
  public GameMessageListUserIconView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(112091);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(112091);
  }
  
  public GameMessageListUserIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112092);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(112092);
  }
  
  private void f(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112098);
    paramImageView = e.bHE().k(paramImageView, paramString);
    if (paramImageView != null) {
      this.nBu.put(paramString, paramImageView);
    }
    AppMethodBeat.o(112098);
  }
  
  private void h(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112097);
    e.a.a locala = new e.a.a();
    locala.eNK = false;
    e.bHE().a(paramImageView, paramString, locala.bHF(), new GameMessageListUserIconView.1(this, paramString));
    AppMethodBeat.o(112097);
  }
  
  private void init()
  {
    AppMethodBeat.i(112094);
    if (this.nBt == null) {
      this.nBt = new o(this.mContext);
    }
    AppMethodBeat.o(112094);
  }
  
  public final void a(n paramn, LinkedList<n.i> paramLinkedList, f<String, Bitmap> paramf)
  {
    AppMethodBeat.i(112096);
    if ((paramn == null) || (bo.es(paramLinkedList)))
    {
      setVisibility(8);
      AppMethodBeat.o(112096);
      return;
    }
    this.nBu = paramf;
    setVisibility(0);
    int i = this.mContext.getResources().getDimensionPixelSize(2131427752);
    int j = this.mContext.getResources().getDimensionPixelSize(2131427496);
    paramf = new LinearLayout.LayoutParams(i, i);
    paramf.rightMargin = j;
    Object localObject;
    while (getChildCount() < paramLinkedList.size())
    {
      localObject = new ImageView(this.mContext);
      ((ImageView)localObject).setLayoutParams(paramf);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject).setOnClickListener(this.nBt);
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
        localObject = (n.i)paramLinkedList.get(i);
        if (!bo.isNullOrNil(((n.i)localObject).noc))
        {
          str = ((n.i)localObject).noc;
          if (this.nBu.Z(str))
          {
            localBitmap = (Bitmap)this.nBu.get(str);
            if ((localBitmap == null) || (localBitmap.isRecycled()))
            {
              h(paramf, str);
              label255:
              if (bo.isNullOrNil(((n.i)localObject).nof)) {
                break label414;
              }
              paramf.setTag(new o.a(paramn, ((n.i)localObject).nof, 6));
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
        h(paramf, str);
        break label255;
        str = ((n.i)localObject).userName;
        if (bo.isNullOrNil(str))
        {
          a.b.c(paramf, str);
          break label255;
        }
        if (!this.nBu.Z(str))
        {
          f(paramf, str);
          break label255;
        }
        localBitmap = (Bitmap)this.nBu.get(str);
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          f(paramf, str);
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
    AppMethodBeat.o(112096);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112093);
    super.onFinishInflate();
    init();
    AppMethodBeat.o(112093);
  }
  
  public void setSourceScene(int paramInt)
  {
    AppMethodBeat.i(112095);
    if (this.nBt != null)
    {
      this.nBt.nok = paramInt;
      AppMethodBeat.o(112095);
      return;
    }
    this.nBt = new o(this.mContext, paramInt);
    AppMethodBeat.o(112095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageListUserIconView
 * JD-Core Version:    0.7.0.1
 */