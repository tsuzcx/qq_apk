package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class q
  extends Exception
{
  private static final StackTraceElement[] aHO = new StackTraceElement[0];
  private g aFH;
  private a aGD;
  private Class<?> aGU;
  private final List<Throwable> aHP;
  private String aHQ;
  public Exception exception;
  
  public q(String paramString)
  {
    this(paramString, Collections.emptyList());
    AppMethodBeat.i(77017);
    AppMethodBeat.o(77017);
  }
  
  public q(String paramString, Throwable paramThrowable)
  {
    this(paramString, Collections.singletonList(paramThrowable));
    AppMethodBeat.i(77018);
    AppMethodBeat.o(77018);
  }
  
  public q(String paramString, List<Throwable> paramList)
  {
    AppMethodBeat.i(77019);
    this.aHQ = paramString;
    setStackTrace(aHO);
    this.aHP = paramList;
    AppMethodBeat.o(77019);
  }
  
  private void a(Appendable paramAppendable)
  {
    AppMethodBeat.i(77026);
    a(this, paramAppendable);
    a(this.aHP, new a(paramAppendable));
    AppMethodBeat.o(77026);
  }
  
  private static void a(Throwable paramThrowable, Appendable paramAppendable)
  {
    AppMethodBeat.i(77028);
    try
    {
      paramAppendable.append(paramThrowable.getClass().toString()).append(": ").append(paramThrowable.getMessage()).append('\n');
      AppMethodBeat.o(77028);
      return;
    }
    catch (IOException paramAppendable)
    {
      paramThrowable = new RuntimeException(paramThrowable);
      AppMethodBeat.o(77028);
      throw paramThrowable;
    }
  }
  
  private void a(Throwable paramThrowable, List<Throwable> paramList)
  {
    AppMethodBeat.i(77022);
    if ((paramThrowable instanceof q))
    {
      paramThrowable = ((q)paramThrowable).aHP.iterator();
      while (paramThrowable.hasNext()) {
        a((Throwable)paramThrowable.next(), paramList);
      }
      AppMethodBeat.o(77022);
      return;
    }
    paramList.add(paramThrowable);
    AppMethodBeat.o(77022);
  }
  
  private static void a(List<Throwable> paramList, Appendable paramAppendable)
  {
    AppMethodBeat.i(77029);
    try
    {
      b(paramList, paramAppendable);
      AppMethodBeat.o(77029);
      return;
    }
    catch (IOException paramList)
    {
      paramList = new RuntimeException(paramList);
      AppMethodBeat.o(77029);
      throw paramList;
    }
  }
  
  private static void b(List<Throwable> paramList, Appendable paramAppendable)
  {
    AppMethodBeat.i(77030);
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      paramAppendable.append("Cause (").append(String.valueOf(i + 1)).append(" of ").append(String.valueOf(j)).append("): ");
      Throwable localThrowable = (Throwable)paramList.get(i);
      if ((localThrowable instanceof q)) {
        ((q)localThrowable).a(paramAppendable);
      }
      for (;;)
      {
        i += 1;
        break;
        a(localThrowable, paramAppendable);
      }
    }
    AppMethodBeat.o(77030);
  }
  
  private List<Throwable> oW()
  {
    AppMethodBeat.i(77020);
    ArrayList localArrayList = new ArrayList();
    a(this, localArrayList);
    AppMethodBeat.o(77020);
    return localArrayList;
  }
  
  final void a(g paramg, a parama, Class<?> paramClass)
  {
    this.aFH = paramg;
    this.aGD = parama;
    this.aGU = paramClass;
  }
  
  public final Throwable fillInStackTrace()
  {
    return this;
  }
  
  public final String getMessage()
  {
    AppMethodBeat.i(77027);
    Object localObject2 = new StringBuilder(71).append(this.aHQ);
    if (this.aGU != null)
    {
      localObject1 = ", " + this.aGU;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      if (this.aGD == null) {
        break label153;
      }
      localObject1 = ", " + this.aGD;
      label82:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      if (this.aFH == null) {
        break label159;
      }
    }
    label153:
    label159:
    for (Object localObject1 = ", " + this.aFH;; localObject1 = "")
    {
      localObject1 = ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = oW();
      if (!((List)localObject2).isEmpty()) {
        break label165;
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      AppMethodBeat.o(77027);
      return localObject1;
      localObject1 = "";
      break;
      localObject1 = "";
      break label82;
    }
    label165:
    if (((List)localObject2).size() == 1) {
      ((StringBuilder)localObject1).append("\nThere was 1 cause:");
    }
    for (;;)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Throwable localThrowable = (Throwable)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append('\n').append(localThrowable.getClass().getName()).append('(').append(localThrowable.getMessage()).append(')');
      }
      ((StringBuilder)localObject1).append("\nThere were ").append(((List)localObject2).size()).append(" causes:");
    }
    ((StringBuilder)localObject1).append("\n call GlideException#logRootCauses(String) for more detail");
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(77027);
    return localObject1;
  }
  
  public final void oX()
  {
    AppMethodBeat.i(77021);
    List localList = oW();
    int i = 0;
    int j = localList.size();
    while (i < j)
    {
      new StringBuilder("Root cause (").append(i + 1).append(" of ").append(j).append(")");
      localList.get(i);
      i += 1;
    }
    AppMethodBeat.o(77021);
  }
  
  public final void printStackTrace()
  {
    AppMethodBeat.i(77023);
    printStackTrace(System.err);
    AppMethodBeat.o(77023);
  }
  
  public final void printStackTrace(PrintStream paramPrintStream)
  {
    AppMethodBeat.i(77024);
    a(paramPrintStream);
    AppMethodBeat.o(77024);
  }
  
  public final void printStackTrace(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(77025);
    a(paramPrintWriter);
    AppMethodBeat.o(77025);
  }
  
  static final class a
    implements Appendable
  {
    private final Appendable aHR;
    private boolean aHS = true;
    
    a(Appendable paramAppendable)
    {
      this.aHR = paramAppendable;
    }
    
    private static CharSequence s(CharSequence paramCharSequence)
    {
      Object localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      return localObject;
    }
    
    public final Appendable append(char paramChar)
    {
      boolean bool = false;
      AppMethodBeat.i(77014);
      if (this.aHS)
      {
        this.aHS = false;
        this.aHR.append("  ");
      }
      if (paramChar == '\n') {
        bool = true;
      }
      this.aHS = bool;
      this.aHR.append(paramChar);
      AppMethodBeat.o(77014);
      return this;
    }
    
    public final Appendable append(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(77015);
      paramCharSequence = s(paramCharSequence);
      paramCharSequence = append(paramCharSequence, 0, paramCharSequence.length());
      AppMethodBeat.o(77015);
      return paramCharSequence;
    }
    
    public final Appendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      boolean bool2 = false;
      AppMethodBeat.i(77016);
      paramCharSequence = s(paramCharSequence);
      if (this.aHS)
      {
        this.aHS = false;
        this.aHR.append("  ");
      }
      boolean bool1 = bool2;
      if (paramCharSequence.length() > 0)
      {
        bool1 = bool2;
        if (paramCharSequence.charAt(paramInt2 - 1) == '\n') {
          bool1 = true;
        }
      }
      this.aHS = bool1;
      this.aHR.append(paramCharSequence, paramInt1, paramInt2);
      AppMethodBeat.o(77016);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.q
 * JD-Core Version:    0.7.0.1
 */