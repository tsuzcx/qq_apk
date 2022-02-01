package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.e;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.sdk.platformtools.aj;

final class ak
  extends c
{
  private static final int mem;
  private e mel = null;
  
  static
  {
    AppMethodBeat.i(49920);
    mem = aj.getContext().getResources().getDimensionPixelSize(2131165517);
    AppMethodBeat.o(49920);
  }
  
  public final e btP()
  {
    AppMethodBeat.i(49919);
    if (this.mel == null) {
      this.mel = new a();
    }
    e locale = this.mel;
    AppMethodBeat.o(49919);
    return locale;
  }
  
  static final class a
    extends e
  {
    private String[] men;
    
    static
    {
      AppMethodBeat.i(49910);
      g.DE("com.tencent.mm.plugin.emoji.PluginEmoji");
      AppMethodBeat.o(49910);
    }
    
    a()
    {
      super();
      AppMethodBeat.i(49905);
      this.men = null;
      this.men = aj.getContext().getResources().getStringArray(2130903070);
      AppMethodBeat.o(49905);
    }
    
    public final int btQ()
    {
      return 0;
    }
    
    public final int btR()
    {
      if (this.men != null) {
        return this.men.length;
      }
      return 0;
    }
    
    public final Drawable vc(int paramInt)
    {
      AppMethodBeat.i(49906);
      f.bsU();
      ak.b localb = new ak.b(vd(paramInt), ak.mem, (byte)0);
      AppMethodBeat.o(49906);
      return localb;
    }
    
    public final String vd(int paramInt)
    {
      AppMethodBeat.i(49907);
      if ((this.men == null) || (paramInt < 0) || (paramInt > this.men.length - 1))
      {
        AppMethodBeat.o(49907);
        return "";
      }
      Object localObject2 = this.men[paramInt].split(" ");
      Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
      localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
      localObject1 = (char[])localObject1 + (char[])localObject2;
      AppMethodBeat.o(49907);
      return localObject1;
    }
    
    public final String ve(int paramInt)
    {
      AppMethodBeat.i(49909);
      String str = vd(paramInt);
      AppMethodBeat.o(49909);
      return str;
    }
  }
  
  static final class b
    extends Drawable
  {
    private final TextPaint Lm;
    private final int mSize;
    private final String mText;
    private Rect meo;
    
    private b(String paramString, int paramInt)
    {
      AppMethodBeat.i(49911);
      this.mText = paramString;
      this.mSize = paramInt;
      this.Lm = new TextPaint();
      this.Lm.setAntiAlias(true);
      this.Lm.setTextAlign(Paint.Align.CENTER);
      this.Lm.setTextSize(this.mSize);
      this.meo = new Rect();
      this.Lm.getTextBounds(this.mText, 0, this.mText.length(), this.meo);
      AppMethodBeat.o(49911);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(49914);
      paramCanvas.drawText(this.mText, getBounds().width() / 2, getBounds().height() / 2 - (this.Lm.descent() + this.Lm.ascent()) / 2.0F, this.Lm);
      AppMethodBeat.o(49914);
    }
    
    public final int getIntrinsicHeight()
    {
      AppMethodBeat.i(49913);
      int i = this.meo.height();
      AppMethodBeat.o(49913);
      return i;
    }
    
    public final int getIntrinsicWidth()
    {
      AppMethodBeat.i(49912);
      int i = this.meo.width();
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
      this.Lm.setAlpha(paramInt);
      AppMethodBeat.o(49915);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(49916);
      this.Lm.setColorFilter(paramColorFilter);
      AppMethodBeat.o(49916);
    }
  }
  
  static final class c
    extends ContextWrapper
  {
    private Resources mResources;
    
    public c(Context paramContext)
    {
      super();
    }
    
    public final Resources getResources()
    {
      AppMethodBeat.i(49917);
      if ((this.mResources != null) && ((this.mResources instanceof ak.d)))
      {
        localResources = this.mResources;
        AppMethodBeat.o(49917);
        return localResources;
      }
      Resources localResources = super.getResources();
      this.mResources = new ak.d(localResources.getAssets(), localResources.getDisplayMetrics(), localResources.getConfiguration());
      localResources = this.mResources;
      AppMethodBeat.o(49917);
      return localResources;
    }
  }
  
  static final class d
    extends Resources
  {
    d(AssetManager paramAssetManager, DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
    {
      super(paramDisplayMetrics, paramConfiguration);
    }
    
    public final String[] getStringArray(int paramInt)
    {
      AppMethodBeat.i(49918);
      if (2130903068 == paramInt)
      {
        AppMethodBeat.o(49918);
        return new String[0];
      }
      if (2130903069 == paramInt)
      {
        AppMethodBeat.o(49918);
        return new String[0];
      }
      String[] arrayOfString = super.getStringArray(paramInt);
      AppMethodBeat.o(49918);
      return arrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak
 * JD-Core Version:    0.7.0.1
 */