package com.tencent.mm.plugin.appbrand.widget.input;

import android.widget.EditText;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;

public final class o
  extends c
{
  private o(WeakReference<EditText> paramWeakReference)
  {
    super(paramWeakReference);
  }
  
  public static o a(EditText paramEditText)
  {
    return new o(new WeakReference(paramEditText));
  }
  
  protected final f a(int paramInt, f.a parama)
  {
    return new o.b(this, paramInt, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o
 * JD-Core Version:    0.7.0.1
 */