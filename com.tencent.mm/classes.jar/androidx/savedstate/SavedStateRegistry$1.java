package androidx.savedstate;

import androidx.lifecycle.i;
import androidx.lifecycle.j.a;
import androidx.lifecycle.q;

class SavedStateRegistry$1
  implements i
{
  SavedStateRegistry$1(b paramb) {}
  
  public void onStateChanged(q paramq, j.a parama)
  {
    if (parama == j.a.ON_START) {
      this.cci.cch = true;
    }
    while (parama != j.a.ON_STOP) {
      return;
    }
    this.cci.cch = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.savedstate.SavedStateRegistry.1
 * JD-Core Version:    0.7.0.1
 */