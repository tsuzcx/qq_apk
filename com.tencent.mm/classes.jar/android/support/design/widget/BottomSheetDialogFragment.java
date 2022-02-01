package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment
  extends AppCompatDialogFragment
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new a(getContext(), getTheme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.BottomSheetDialogFragment
 * JD-Core Version:    0.7.0.1
 */