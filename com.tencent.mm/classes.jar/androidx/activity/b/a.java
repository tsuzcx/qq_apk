package androidx.activity.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
{
  public final Set<b> eO;
  public volatile Context mContext;
  
  public a()
  {
    AppMethodBeat.i(199185);
    this.eO = new CopyOnWriteArraySet();
    AppMethodBeat.o(199185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.b.a
 * JD-Core Version:    0.7.0.1
 */