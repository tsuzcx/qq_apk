package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public final class d<T>
{
  private static final Executor xY;
  private final s acM;
  final c<T> acN;
  final Executor acO;
  List<T> afN;
  
  static
  {
    AppMethodBeat.i(260775);
    xY = new d.a();
    AppMethodBeat.o(260775);
  }
  
  public d(s params, c<T> paramc)
  {
    AppMethodBeat.i(260773);
    this.afN = Collections.emptyList();
    this.acM = params;
    this.acN = paramc;
    if (paramc.acO != null)
    {
      this.acO = paramc.acO;
      AppMethodBeat.o(260773);
      return;
    }
    this.acO = xY;
    AppMethodBeat.o(260773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.d
 * JD-Core Version:    0.7.0.1
 */