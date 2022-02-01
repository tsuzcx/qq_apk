package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.ColorUtil.MMViewType;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.KButton;
import com.tencent.kinda.gen.KImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;

public class MMKButton
  extends MMKView<KindaButtonImpl>
  implements KButton
{
  public static final String TAG = "MMKView.MMKButton";
  private long disabledColor;
  private MMKImage disabledImage;
  private FontStyle fontStyle;
  private boolean isEnableHighlight;
  private DynamicColor normalColor;
  private MMKImage normalImage;
  private long pressedColor;
  private MMKImage pressedImage;
  private long selectedColor;
  private MMKImage selectedImage;
  private long textDisabledColor;
  private String textFontName;
  private DynamicColor textNormalColor;
  private long textPressedColor;
  private long textSelectedColor;
  private float textSize;
  
  public MMKButton()
  {
    AppMethodBeat.i(18995);
    this.textSelectedColor = -1L;
    this.textNormalColor = new DynamicColor(-1L, 0L);
    this.textPressedColor = -1L;
    this.textDisabledColor = -1L;
    this.selectedColor = -1L;
    this.normalColor = new DynamicColor(-1L, 0L);
    this.pressedColor = -1L;
    this.disabledColor = -1L;
    this.isEnableHighlight = true;
    this.fontStyle = FontStyle.REGULAR;
    AppMethodBeat.o(18995);
  }
  
  private void updateBackgroundWithColor()
  {
    AppMethodBeat.i(19011);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    BackgroundColorDrawable localBackgroundColorDrawable;
    if ((this.isEnableHighlight) && (this.pressedColor >= 0L))
    {
      localBackgroundColorDrawable = new BackgroundColorDrawable(MMKViewUtil.argbColor(this.pressedColor));
      localStateListDrawable.addState(new int[] { 16842919 }, localBackgroundColorDrawable);
    }
    if (this.selectedColor >= 0L)
    {
      localBackgroundColorDrawable = new BackgroundColorDrawable(MMKViewUtil.argbColor(this.selectedColor));
      localStateListDrawable.addState(new int[] { 16842913 }, localBackgroundColorDrawable);
    }
    if (this.disabledColor >= 0L)
    {
      localBackgroundColorDrawable = new BackgroundColorDrawable(MMKViewUtil.argbColor(this.disabledColor));
      localStateListDrawable.addState(new int[] { -16842910 }, localBackgroundColorDrawable);
    }
    if (ColorUtil.getColorByMode(this.normalColor) >= 0L)
    {
      localBackgroundColorDrawable = new BackgroundColorDrawable(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(this.normalColor)));
      localStateListDrawable.addState(new int[0], localBackgroundColorDrawable);
    }
    setViewBackground(localStateListDrawable);
    AppMethodBeat.o(19011);
  }
  
  private void updateBackgroundWithImage()
  {
    AppMethodBeat.i(19010);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable;
    if ((this.isEnableHighlight) && (this.pressedImage != null) && (!this.pressedImage.isNetworkImage()))
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
    AppMethodBeat.o(19010);
  }
  
  private void updateTextColor()
  {
    int j = 0;
    AppMethodBeat.i(19003);
    if ((ColorUtil.getColorByModeNoCompat(this.textNormalColor) >= 0L) || (this.textSelectedColor >= 0L) || (this.textPressedColor >= 0L) || (this.textDisabledColor >= 0L))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      if (this.textSelectedColor >= 0L)
      {
        ((ArrayList)localObject1).add(new int[] { 16842913 });
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(this.textSelectedColor)));
      }
      if ((this.isEnableHighlight) && (this.textPressedColor >= 0L))
      {
        ((ArrayList)localObject1).add(new int[] { 16842919 });
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(this.textPressedColor)));
      }
      if (this.textDisabledColor >= 0L)
      {
        ((ArrayList)localObject1).add(new int[] { -16842910 });
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(this.textDisabledColor)));
      }
      if (ColorUtil.getColorByModeNoCompat(this.textNormalColor) >= 0L)
      {
        ((ArrayList)localObject1).add(new int[0]);
        ((ArrayList)localObject2).add(Integer.valueOf(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(this.textNormalColor))));
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
    AppMethodBeat.o(19003);
  }
  
  private void updateTypeface()
  {
    AppMethodBeat.i(214513);
    int i;
    if (this.textFontName != null) {
      if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
        i = 2;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        String str = f.aqk(i);
        try
        {
          ((KindaButtonImpl)getView()).getKButtonTextView().setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), str));
          AppMethodBeat.o(214513);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MMKView.MMKButton", "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          AppMethodBeat.o(214513);
          return;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Medium"))
        {
          i = 0;
          continue;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Regular"))
        {
          i = 3;
          continue;
        }
        if (!this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Bold")) {
          break label203;
        }
        i = 1;
        continue;
      }
      if (this.fontStyle == FontStyle.REGULAR)
      {
        ((KindaButtonImpl)getView()).getKButtonTextView().setTypeface(null, 0);
        AppMethodBeat.o(214513);
        return;
      }
      ((KindaButtonImpl)getView()).getKButtonTextView().setTypeface(null, 1);
      AppMethodBeat.o(214513);
      return;
      label203:
      i = -1;
    }
  }
  
  public KindaButtonImpl createView(Context paramContext)
  {
    AppMethodBeat.i(18996);
    paramContext = new KindaButtonImpl(paramContext);
    paramContext.setClickable(true);
    paramContext.setEnabled(true);
    AppMethodBeat.o(18996);
    return paramContext;
  }
  
  public KImage getDisabledImage()
  {
    return this.disabledImage;
  }
  
  public boolean getEnable()
  {
    AppMethodBeat.i(19009);
    boolean bool = ((KindaButtonImpl)getView()).isEnabled();
    AppMethodBeat.o(19009);
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
    return this.fontStyle;
  }
  
  public DynamicColor getNormalColor()
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
    AppMethodBeat.i(18998);
    if (((KindaButtonImpl)getView()).getText() != null)
    {
      String str = ((KindaButtonImpl)getView()).getText().toString();
      AppMethodBeat.o(18998);
      return str;
    }
    AppMethodBeat.o(18998);
    return null;
  }
  
  public String getTextFont()
  {
    return this.textFontName;
  }
  
  public DynamicColor getTextNormalColor()
  {
    return this.textNormalColor;
  }
  
  public float getTextSize()
  {
    return this.textSize;
  }
  
  public void setDisabledImage(KImage paramKImage)
  {
    AppMethodBeat.i(19007);
    if ((paramKImage instanceof MMKImage))
    {
      this.disabledImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(19007);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(19008);
    ((KindaButtonImpl)getView()).setEnabled(paramBoolean);
    ((KindaButtonImpl)getView()).setClickable(paramBoolean);
    AppMethodBeat.o(19008);
  }
  
  public void setEnableHighLight(boolean paramBoolean)
  {
    this.isEnableHighlight = paramBoolean;
  }
  
  public void setExpandHitHeight(long paramLong) {}
  
  public void setExpandHitWidth(long paramLong) {}
  
  public void setFontStyle(FontStyle paramFontStyle)
  {
    AppMethodBeat.i(214512);
    this.fontStyle = paramFontStyle;
    updateTypeface();
    AppMethodBeat.o(214512);
  }
  
  public void setNormalColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(18999);
    if (ColorUtil.getColorByModeNoCompat(this.normalColor) != ColorUtil.getColorByMode(paramDynamicColor))
    {
      this.normalColor = paramDynamicColor;
      if (ColorUtil.getColorByModeNoCompat(paramDynamicColor) != 0L)
      {
        this.pressedColor = ColorUtil.MergeColors(ColorUtil.getColorByModeNoCompat(paramDynamicColor), 436207616L);
        if (!ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
          break label142;
        }
      }
      label142:
      for (this.disabledColor = Long.parseLong("14FFFFFF", 16);; this.disabledColor = ColorUtil.MergeColors(ColorUtil.getColorByModeNoCompat(paramDynamicColor), 2583691263L))
      {
        updateBackgroundWithColor();
        Log.i("MMKView.MMKButton", "MMKButton[" + getText() + "] setNormalColor设置完成后，normalColor：" + this.normalColor + "，pressedColor：" + this.pressedColor + "，disabledColor：" + this.disabledColor);
        AppMethodBeat.o(18999);
        return;
      }
    }
    Log.i("MMKView.MMKButton", "MMKButton[" + getText() + "] setNormalColor设置相同值。");
    AppMethodBeat.o(18999);
  }
  
  public void setNormalImage(KImage paramKImage)
  {
    AppMethodBeat.i(19004);
    if ((paramKImage instanceof MMKImage))
    {
      this.normalImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(19004);
  }
  
  public void setPressedImage(KImage paramKImage)
  {
    AppMethodBeat.i(19005);
    if ((paramKImage instanceof MMKImage))
    {
      this.pressedImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(19005);
  }
  
  public void setSelectedImage(KImage paramKImage)
  {
    AppMethodBeat.i(19006);
    if ((paramKImage instanceof MMKImage))
    {
      this.selectedImage = ((MMKImage)paramKImage);
      updateBackgroundWithImage();
    }
    AppMethodBeat.o(19006);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(18997);
    if (paramString != null) {
      ((KindaButtonImpl)getView()).setText(paramString);
    }
    AppMethodBeat.o(18997);
  }
  
  public void setTextFont(String paramString)
  {
    AppMethodBeat.i(19001);
    if (paramString != null)
    {
      this.textFontName = paramString;
      ((KindaButtonImpl)getView()).setTextFont(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), paramString));
      notifyChanged();
    }
    AppMethodBeat.o(19001);
  }
  
  public void setTextNormalColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19002);
    if (ColorUtil.getColorByModeNoCompat(this.textNormalColor) != ColorUtil.getColorByMode(paramDynamicColor, ColorUtil.MMViewType.MMKButtonText))
    {
      this.textNormalColor = paramDynamicColor;
      long l = 0x99000000 | ColorUtil.getColorByModeNoCompat(paramDynamicColor) & 0xFFFFFF;
      this.textPressedColor = l;
      this.textDisabledColor = l;
      Log.d("MMKView.MMKButton", "100mango pressedColor" + Long.toString(this.textPressedColor) + "disableColor" + Long.toString(this.textDisabledColor));
      Log.d("MMKView.MMKButton", "100mango pressedColor" + Long.toHexString(this.textPressedColor) + "disableColor" + Long.toHexString(this.textDisabledColor));
      updateTextColor();
    }
    AppMethodBeat.o(19002);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(19000);
    this.textSize = paramFloat;
    if (paramFloat > 0.0F) {
      ((KindaButtonImpl)getView()).setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), paramFloat));
    }
    AppMethodBeat.o(19000);
  }
  
  static class BackgroundColorDrawable
    extends Drawable
  {
    private int color;
    
    BackgroundColorDrawable(int paramInt)
    {
      this.color = paramInt;
    }
    
    public void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(18993);
      paramCanvas.drawColor(this.color);
      AppMethodBeat.o(18993);
    }
    
    public int getOpacity()
    {
      AppMethodBeat.i(18994);
      if (this.color == 0)
      {
        AppMethodBeat.o(18994);
        return -2;
      }
      if (Color.alpha(this.color) > 0)
      {
        AppMethodBeat.o(18994);
        return -3;
      }
      AppMethodBeat.o(18994);
      return -1;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKButton
 * JD-Core Version:    0.7.0.1
 */