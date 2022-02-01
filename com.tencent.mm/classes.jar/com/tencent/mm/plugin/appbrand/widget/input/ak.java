package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.sdk.platformtools.aj;

final class ak
  extends c
{
  private static final int ngJ;
  private e ngI = null;
  
  static
  {
    AppMethodBeat.i(49920);
    ngJ = aj.getContext().getResources().getDimensionPixelSize(2131165517);
    AppMethodBeat.o(49920);
  }
  
  public final e bEQ()
  {
    AppMethodBeat.i(49919);
    if (this.ngI == null) {
      this.ngI = new a();
    }
    e locale = this.ngI;
    AppMethodBeat.o(49919);
    return locale;
  }
  
  static final class a
    extends e
  {
    private String[] ngK;
    
    static
    {
      AppMethodBeat.i(49910);
      g.La("com.tencent.mm.plugin.emoji.PluginEmoji");
      AppMethodBeat.o(49910);
    }
    
    a()
    {
      super();
      AppMethodBeat.i(49905);
      this.ngK = null;
      this.ngK = aj.getContext().getResources().getStringArray(2130903070);
      AppMethodBeat.o(49905);
    }
    
    public final int bER()
    {
      return 0;
    }
    
    public final int bES()
    {
      if (this.ngK != null) {
        return this.ngK.length;
      }
      return 0;
    }
    
    public final String wA(int paramInt)
    {
      AppMethodBeat.i(49909);
      String str = wz(paramInt);
      AppMethodBeat.o(49909);
      return str;
    }
    
    public final Drawable wy(int paramInt)
    {
      AppMethodBeat.i(49906);
      f.bDW();
      ak.b localb = new ak.b(wz(paramInt), ak.ngJ, (byte)0);
      AppMethodBeat.o(49906);
      return localb;
    }
    
    public final String wz(int paramInt)
    {
      AppMethodBeat.i(49907);
      if ((this.ngK == null) || (paramInt < 0) || (paramInt > this.ngK.length - 1))
      {
        AppMethodBeat.o(49907);
        return "";
      }
      Object localObject2 = this.ngK[paramInt].split(" ");
      Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
      localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
      localObject1 = (char[])localObject1 + (char[])localObject2;
      AppMethodBeat.o(49907);
      return localObject1;
    }
  }
  
  static final class b
    extends Drawable
  {
    private final TextPaint NZ;
    private final int mSize;
    private final String mText;
    private Rect ngL;
    
    private b(String paramString, int paramInt)
    {
      AppMethodBeat.i(49911);
      this.mText = paramString;
      this.mSize = paramInt;
      this.NZ = new TextPaint();
      this.NZ.setAntiAlias(true);
      this.NZ.setTextAlign(Paint.Align.CENTER);
      this.NZ.setTextSize(this.mSize);
      this.ngL = new Rect();
      this.NZ.getTextBounds(this.mText, 0, this.mText.length(), this.ngL);
      AppMethodBeat.o(49911);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(49914);
      paramCanvas.drawText(this.mText, getBounds().width() / 2, getBounds().height() / 2 - (this.NZ.descent() + this.NZ.ascent()) / 2.0F, this.NZ);
      AppMethodBeat.o(49914);
    }
    
    public final int getIntrinsicHeight()
    {
      AppMethodBeat.i(49913);
      int i = this.ngL.height();
      AppMethodBeat.o(49913);
      return i;
    }
    
    public final int getIntrinsicWidth()
    {
      AppMethodBeat.i(49912);
      int i = this.ngL.width();
      AppMethodBeat.o(49912);
      return i;
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(49915);
      this.NZ.setAlpha(paramInt);
      AppMethodBeat.o(49915);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(49916);
      this.NZ.setColorFilter(paramColorFilter);
      AppMethodBeat.o(49916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak
 * JD-Core Version:    0.7.0.1
 */