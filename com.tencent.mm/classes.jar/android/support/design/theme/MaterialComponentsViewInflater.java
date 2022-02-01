package android.support.design.theme;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

@Keep
public class MaterialComponentsViewInflater
  extends AppCompatViewInflater
{
  public AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialButton(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.theme.MaterialComponentsViewInflater
 * JD-Core Version:    0.7.0.1
 */