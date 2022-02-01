package com.tencent.mm.bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.a.a.b;
import java.io.OutputStream;

public class a
{
  protected static final int OPCODE_COMPUTESIZE = 1;
  protected static final int OPCODE_PARSEFROM = 2;
  protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
  protected static final int OPCODE_WRITEFIELDS = 0;
  protected static b unknownTagHandler;
  private boolean includeUnKnownField = false;
  private byte[] pbData;
  
  static
  {
    AppMethodBeat.i(2349);
    unknownTagHandler = i.a.a.a.a.a.kFU();
    AppMethodBeat.o(2349);
  }
  
  public static int getNextFieldNumber(i.a.a.a.a parama)
  {
    AppMethodBeat.i(2351);
    int i = parama.kFS();
    AppMethodBeat.o(2351);
    return i;
  }
  
  public int computeSize()
  {
    AppMethodBeat.i(2354);
    try
    {
      int i = op(1, new Object[0]);
      AppMethodBeat.o(2354);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(2354);
    }
    return 0;
  }
  
  public byte[] getData()
  {
    return this.pbData;
  }
  
  public boolean isIncludeUnKnownField()
  {
    return this.includeUnKnownField;
  }
  
  protected int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2352);
    paramVarArgs = new Error("Cannot use this method");
    AppMethodBeat.o(2352);
    throw paramVarArgs;
  }
  
  public a parseFrom(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2355);
    this.pbData = paramArrayOfByte;
    op(2, new Object[] { paramArrayOfByte });
    AppMethodBeat.o(2355);
    return this;
  }
  
  public boolean populateBuilderWithField(i.a.a.a.a parama, a parama1, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(2356);
    if (op(3, new Object[] { parama, parama1, Integer.valueOf(paramInt) }) == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.includeUnKnownField) || (!bool1)) {
        bool2 = true;
      }
      this.includeUnKnownField = bool2;
      AppMethodBeat.o(2356);
      return bool1;
    }
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(2350);
    validate();
    i.a.a.c.a locala = new i.a.a.c.a(new byte[computeSize()]);
    writeFields(locala);
    locala.ajGn = null;
    Object localObject = locala.ajGo;
    if (((i.a.a.b.b.a)localObject).limit - ((i.a.a.b.b.a)localObject).position != 0)
    {
      int i = locala.ajGo.position;
      localObject = new byte[i];
      System.arraycopy(locala.ajGm, 0, localObject, 0, i);
      locala.ajGn = ((byte[])localObject);
      if (locala.osU != null)
      {
        if ((locala.ajGn == null) || (locala.ajGn.length <= 0)) {
          break label136;
        }
        locala.osU.write(locala.ajGn);
        locala.osU.flush();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(2350);
      return localObject;
      localObject = locala.ajGm;
      break;
      label136:
      locala.kGd();
    }
  }
  
  public Object toJSON()
  {
    return "";
  }
  
  public a toPb(String paramString)
  {
    return this;
  }
  
  protected a validate()
  {
    return this;
  }
  
  public void writeFields(i.a.a.c.a parama)
  {
    AppMethodBeat.i(2353);
    op(0, new Object[] { parama });
    AppMethodBeat.o(2353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bx.a
 * JD-Core Version:    0.7.0.1
 */