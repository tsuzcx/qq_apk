package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/Keyboard;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getUpperMode", "isUpper", "", "onCreate", "", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSelectCandidate", "text", "", "id", "", "suffix", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "switchUpperMode", "upperMode", "transparentBg", "transparent", "updateEnterKey", "actionStr", "actionMode", "updateUpperKey", "DeleteKeyData", "plugin-hld_release"})
public abstract class Keyboard
  extends LinearLayout
{
  public Keyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Keyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Keyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, 0);
  }
  
  public abstract void Uu(int paramInt);
  
  public abstract void a(String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract void b(com.tencent.mm.plugin.hld.a.c paramc);
  
  public abstract boolean eDJ();
  
  public abstract void eDK();
  
  public abstract void eO(String paramString, int paramInt);
  
  public abstract c getKeyboardType();
  
  public abstract int getUpperMode();
  
  public abstract void onCreate();
  
  public abstract void onReset();
  
  public abstract void sM(boolean paramBoolean);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/Keyboard$DeleteKeyData;", "", "deleteType", "", "deleteLength", "(II)V", "getDeleteLength", "()I", "getDeleteType", "plugin-hld_release"})
  public static final class a
  {
    public final int Dyj;
    public final int Dyk;
    
    public a(int paramInt1, int paramInt2)
    {
      this.Dyj = paramInt1;
      this.Dyk = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.Keyboard
 * JD-Core Version:    0.7.0.1
 */