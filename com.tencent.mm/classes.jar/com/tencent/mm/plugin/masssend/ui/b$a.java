package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import com.tencent.mm.f.b.h;

final class b$a
  extends h
{
  String fileName;
  
  public b$a(b paramb, Context paramContext)
  {
    super(paramContext, false);
  }
  
  public final String getFileName()
  {
    return this.fileName;
  }
  
  public final boolean un()
  {
    this.fileName = super.getFileName();
    boolean bool = super.un();
    super.reset();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.a
 * JD-Core Version:    0.7.0.1
 */