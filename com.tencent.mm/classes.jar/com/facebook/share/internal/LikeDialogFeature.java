package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum LikeDialogFeature
  implements DialogFeature
{
  private int minVersion;
  
  static
  {
    AppMethodBeat.i(8145);
    LIKE_DIALOG = new LikeDialogFeature("LIKE_DIALOG", 0, 20140701);
    $VALUES = new LikeDialogFeature[] { LIKE_DIALOG };
    AppMethodBeat.o(8145);
  }
  
  private LikeDialogFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public final String getAction()
  {
    return "com.facebook.platform.action.request.LIKE_DIALOG";
  }
  
  public final int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.internal.LikeDialogFeature
 * JD-Core Version:    0.7.0.1
 */