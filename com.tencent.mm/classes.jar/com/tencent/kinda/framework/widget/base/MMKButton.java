package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.KButton;
import com.tencent.kinda.gen.KImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

public class MMKButton
  extends MMKView<KindaButtonImpl>
  implements KButton
{
  public static final String TAG = "MMKView.MMKButton";
  private long disabledColor = -1L;
  private MMKImage disabledImage;
  private long normalColor = -1L;
  private MMKImage normalImage;
  private long pressedColor = -1L;
  private MMKImage pressedImage;
  private long selectedColor = -1L;
  private MMKImage selectedImage;
  private long textDisabledColor = -1L;
  private String textFontName;
  private long textNormalColor = -1L;
  private long textPressedColor = -1L;
  private long textSelectedColor = -1L;
  private float textSize;
  
  private void updateBackgroundWithColor()
  {
    AppMethodBeat.i(144859);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    MMKButton.BackgroundColorDrawable localBackgroundColorDrawable;
    if (this.pressedColor >= 0L)
    {
      localBackgroundColorDrawable = new MMKButton.BackgroundColorDrawable(MMKViewUtil.argbColor(this.pressedColor));
      localStateListDrawable.addState(new int[] { 16842919 }, localBackgroundColorDrawable);
    }
    if (this.selectedColor >= 0L)
    {
      localBackgroundColorDrawable = new MMKButton.BackgroundColorDrawable(MMKViewUtil.argbColor(this.selectedColor));
      localStateListDrawable.addState(new int[] { 16842913 }, localBackgroundColorDrawable);
    }
    if (this.disabledColor >= 0L)
    {
      localBackgroundColorDrawable = new MMKButton.BackgroundColorDrawable(MMKViewUtil.argbColor(this.disabledColor));
      localStateListDrawable.addState(new int[] { -16842910 }, localBackgroundColorDrawable);
    }
    if (this.normalColor >= 0L)
    {
      localBackgroundColorDrawable = new MMKButton.BackgroundColorDrawable(MMKViewUtil.argbColor(this.normalColor));
      localStateListDrawable.addState(new int[0], localBackgroundColorDrawable);
    }
    setViewBackground(localStateListDrawable);
    AppMethodBeat.o(144859);
  }
  
  private void updateBackgroundWithImage()
  {
    AppMethodBeat.i(144858);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable;
    if ((this.pressedImage != null) && (!this.pressedImage.isNetworkImage()))
    {
      localDrawable = this.pressedImage.getDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    }
    if ((this.selectedImage != null) && (!this.selectedImage.isNetworkImage()))
    {
      localDrawable = this.selectedImage.getDrawable();
      localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    }
    if ((this.disabledImage != null) && (!this.disabledImage.isNetworkImage()))
    {
      localDrawable = this.disabledImage.getDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, localDrawable);
    }
    if ((this.normalImage != null) && (!this.normalImage.isNetworkImage()))
    {
      localDrawable = this.normalImage.getDrawable();
      localStateListDrawable.addState(new int[0], localDrawable);
    }
    ((KindaButtonImpl)getView()).setImageDrawable(localStateListDrawable);
    AppMethodBeat.o(144858);
  }
  
  private void updateTextColor()
  {
    int j = 0;
    AppMethodBeat.i(144851);
    if ((this.textNormalColor >= 0L) || (this.textSelectedColor >= 0L) || (this.textPressedColor >= 0L) || (this.textDisabledColor >= 0L))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      if (this.textSelectedColor >= 0L)
      {
        ((ArrayList)localObject1).add(new int[] { 16842913 });
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(this.textSelectedColor)));
      }
      if (this.textPressedColor >= 0L)
      {
        ((ArrayList)localObject1).add(new int[] { 16842919 });
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(this.textPressedColor)));
      }
      if (this.textDisabledColor >= 0L)
      {
        ((ArrayList)localObject1).add(new int[] { -16842910 });
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(this.textDisabledColor)));
      }
      if (this.textNormalColor >= 0L)
      {
        ((ArrayList)localObject1).add(new int[0]);
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(this.textNormalColor)));
      }
      int[] arrayOfInt = new int[((ArrayList)localObject2).size()];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = ((Integer)((ArrayList)localObject2).get(i)).intValue();
        i += 1;
      }
      localObject2 = new int[((ArrayList)localObject1).size()][];
      i = j;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2[i] = ((int[])((ArrayList)localObject1).get(i));
        i += 1;
      }
      localObject1 = new ColorStateList((int[][])localObject2, arrayOfInt);
      ((KindaButtonImpl)getView()).setTextColor((ColorStateList)localObject1);
    }
    AppMethodBeat.o(144851);
  }
  
  public KindaButtonImpl createView(Context paramContext)
  {
    AppMethodBeat.i(144844);
    paramContext = new KindaButtonImpl(paramContext);
    paramContext.setClickable(true);
    paramContext.setEnabled(true);
    AppMethodBeat.o(144844);
    return paramContext;
  }
  
  public KImage getDisabledImage()
  {
    return this.disabledImage;
  }
  
  public boolean getEnable()
  {
    AppMethodBeat.i(144857);
    boolean bool = ((KindaButtonImpl)getView()).isEnabled();
    AppMethodBeat.o(144857);
    return bool;
  }
  
  public long getExpandHitHeight()
  {
    return 0L;
  }
  
  public long getExpandHitWidth()
  {
    return 0L;
  }
  
  public FontStyle getFontStyle()
  {
    return null;
  }
  
  public long getNormalColor()
  {
    return this.normalColor;
  }
  
  public KImage getNormalImage()
  {
    return this.normalImage;
  }
  
  public KImage getPressedImage()
  {
    return this.pressedImage;
  }
  
  public KImage getSelectedImage()
  {
    return this.selectedImage;
  }
  
  public String getText()
  {
    AppMethodBeat.i(144846);
    if (((KindaButtonImpl)getView()).getText() != null)
    {
      String str = ((KindaButtonImpl)getView()).getText().toString();
      AppMethodBeat.o(144846);
      return str;
    }
    AppMethodBeat.o(144846);
    return null;
  }
  
  public String getTextFont()
  {
    return this.textFontName;
  }
  
  public long getTextNormalColor()
  {
    return this.textNormalColor;
  }
  
  public float getTextSize()
  {
    return this.textSize;
  }
  
  public void setDisabledImage(KImage paramKImage)
  {
    AppMethodBeat.i(144855);
    if ((paramKImage instanceof MMKImage))
    {
      this.disabledImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(144855);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(144856);
    ((KindaButtonImpl)getView()).setEnabled(paramBoolean);
    ((KindaButtonImpl)getView()).setClickable(paramBoolean);
    AppMethodBeat.o(144856);
  }
  
  public void setExpandHitHeight(long paramLong) {}
  
  public void setExpandHitWidth(long paramLong) {}
  
  public void setFontStyle(FontStyle paramFontStyle) {}
  
  public void setNormalColor(long paramLong)
  {
    AppMethodBeat.i(144847);
    if (this.normalColor != paramLong)
    {
      this.normalColor = paramLong;
      if (paramLong != 0L)
      {
        this.pressedColor = ColorUtil.MergeColors(paramLong, 436207616L);
        this.disabledColor = ColorUtil.MergeColors(paramLong, 2583691263L);
      }
      updateBackgroundWithColor();
      ab.i("MMKView.MMKButton", "MMKButton[" + getText() + "] setNormalColor设置完成后，normalColor：" + this.normalColor + "，pressedColor：" + this.pressedColor + "，disabledColor：" + this.disabledColor);
      AppMethodBeat.o(144847);
      return;
    }
    ab.i("MMKView.MMKButton", "MMKButton[" + getText() + "] setNormalColor设置相同值。");
    AppMethodBeat.o(144847);
  }
  
  public void setNormalImage(KImage paramKImage)
  {
    AppMethodBeat.i(144852);
    if ((paramKImage instanceof MMKImage))
    {
      this.normalImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(144852);
  }
  
  public void setPressedImage(KImage paramKImage)
  {
    AppMethodBeat.i(144853);
    if ((paramKImage instanceof MMKImage))
    {
      this.pressedImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(144853);
  }
  
  public void setSelectedImage(KImage paramKImage)
  {
    AppMethodBeat.i(144854);
    if ((paramKImage instanceof MMKImage))
    {
      this.selectedImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(144854);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(144845);
    if (paramString != null) {
      ((KindaButtonImpl)getView()).setText(paramString);
    }
    AppMethodBeat.o(144845);
  }
  
  public void setTextFont(String paramString)
  {
    AppMethodBeat.i(144849);
    if (paramString != null)
    {
      this.textFontName = paramString;
      ((KindaButtonImpl)getView()).setTextFont(Typeface.createFromAsset(ah.getContext().getAssets(), paramString));
      notifyChanged();
    }
    AppMethodBeat.o(144849);
  }
  
  public void setTextNormalColor(long paramLong)
  {
    AppMethodBeat.i(144850);
    if (this.textNormalColor != paramLong)
    {
      this.textNormalColor = paramLong;
      paramLong = 0x99000000 | 0xFFFFFF & paramLong;
      this.textPressedColor = paramLong;
      this.textDisabledColor = paramLong;
      ab.d("MMKView.MMKButton", "100mango pressedColor" + Long.toString(this.textPressedColor) + "disableColor" + Long.toString(this.textDisabledColor));
      ab.d("MMKView.MMKButton", "100mango pressedColor" + Long.toHexString(this.textPressedColor) + "disableColor" + Long.toHexString(this.textDisabledColor));
      updateTextColor();
    }
    AppMethodBeat.o(144850);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(144848);
    this.textSize = paramFloat;
    if (paramFloat > 0.0F) {
      ((KindaButtonImpl)getView()).setTextSize(0, MMKViewUtil.dpToPx(ah.getContext(), paramFloat));
    }
    AppMethodBeat.o(144848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKButton
 * JD-Core Version:    0.7.0.1
 */