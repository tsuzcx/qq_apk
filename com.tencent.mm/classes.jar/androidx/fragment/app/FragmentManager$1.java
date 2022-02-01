package androidx.fragment.app;

import androidx.activity.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FragmentManager$1
  extends b
{
  FragmentManager$1(FragmentManager paramFragmentManager)
  {
    super(false);
  }
  
  public final void handleOnBackPressed()
  {
    AppMethodBeat.i(193885);
    this.bCP.handleOnBackPressed();
    AppMethodBeat.o(193885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.1
 * JD-Core Version:    0.7.0.1
 */