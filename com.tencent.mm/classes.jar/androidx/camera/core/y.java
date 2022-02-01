package androidx.camera.core;

import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class y
{
  public final List<an> Hl;
  public final List<an> Hm;
  public final List<an> Hn;
  public final long Ho;
  
  public y(a parama)
  {
    AppMethodBeat.i(198539);
    this.Hl = Collections.unmodifiableList(parama.Hl);
    this.Hm = Collections.unmodifiableList(parama.Hm);
    this.Hn = Collections.unmodifiableList(parama.Hn);
    this.Ho = parama.Ho;
    AppMethodBeat.o(198539);
  }
  
  public static final class a
  {
    final List<an> Hl;
    final List<an> Hm;
    final List<an> Hn;
    public long Ho;
    
    public a(an paraman)
    {
      this(paraman, (byte)0);
    }
    
    private a(an paraman, byte paramByte)
    {
      AppMethodBeat.i(198550);
      this.Hl = new ArrayList();
      this.Hm = new ArrayList();
      this.Hn = new ArrayList();
      this.Ho = 5000L;
      if (paraman != null) {}
      for (boolean bool = true;; bool = false)
      {
        f.checkArgument(bool, "Point cannot be null.");
        f.checkArgument(true, "Invalid metering mode 7");
        this.Hl.add(paraman);
        this.Hm.add(paraman);
        this.Hn.add(paraman);
        AppMethodBeat.o(198550);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.y
 * JD-Core Version:    0.7.0.1
 */