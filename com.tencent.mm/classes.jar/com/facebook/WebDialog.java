package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebDialog
{
  public static int getWebDialogTheme()
  {
    AppMethodBeat.i(7621);
    int i = com.facebook.internal.WebDialog.getWebDialogTheme();
    AppMethodBeat.o(7621);
    return i;
  }
  
  public static void setWebDialogTheme(int paramInt)
  {
    AppMethodBeat.i(7622);
    com.facebook.internal.WebDialog.setWebDialogTheme(paramInt);
    AppMethodBeat.o(7622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.WebDialog
 * JD-Core Version:    0.7.0.1
 */