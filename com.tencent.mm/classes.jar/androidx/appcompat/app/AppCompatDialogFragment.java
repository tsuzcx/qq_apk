package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatDialogFragment
  extends DialogFragment
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(238363);
    paramBundle = new e(getContext(), getTheme());
    AppMethodBeat.o(238363);
    return paramBundle;
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    AppMethodBeat.i(238364);
    if ((paramDialog instanceof e))
    {
      e locale = (e)paramDialog;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(238364);
        return;
        paramDialog.getWindow().addFlags(24);
        locale.bb();
      }
    }
    super.setupDialog(paramDialog, paramInt);
    AppMethodBeat.o(238364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDialogFragment
 * JD-Core Version:    0.7.0.1
 */