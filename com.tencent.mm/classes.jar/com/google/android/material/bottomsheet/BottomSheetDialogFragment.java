package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BottomSheetDialogFragment
  extends AppCompatDialogFragment
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(209510);
    paramBundle = new a(getContext(), getTheme());
    AppMethodBeat.o(209510);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialogFragment
 * JD-Core Version:    0.7.0.1
 */