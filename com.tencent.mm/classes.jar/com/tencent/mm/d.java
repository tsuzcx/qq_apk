package com.tencent.mm;

import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;
import android.renderscript.Type;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends ScriptC
{
  private Element cPR;
  private Element cPS;
  private Element cPT;
  private Element cPU;
  private FieldPacker cPV;
  private Allocation cPW;
  private int cPX;
  private int cPY;
  private long cPZ;
  private long cQa;
  private long cQb;
  private long cQc;
  private Allocation cQd;
  private Allocation cQe;
  private Allocation cQf;
  
  public d(RenderScript paramRenderScript)
  {
    super(paramRenderScript, "imagerenderscriptutil", a.JW(), a.JX());
    AppMethodBeat.i(93336);
    this.cPR = Element.ALLOCATION(paramRenderScript);
    this.cPS = Element.I32(paramRenderScript);
    this.cPT = Element.U32(paramRenderScript);
    this.cPU = Element.U8_4(paramRenderScript);
    AppMethodBeat.o(93336);
  }
  
  /* Error */
  public final void Kg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 77
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   11: ifnull +40 -> 51
    //   14: aload_0
    //   15: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   18: invokevirtual 84	android/renderscript/FieldPacker:reset	()V
    //   21: aload_0
    //   22: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   25: lconst_0
    //   26: invokevirtual 88	android/renderscript/FieldPacker:addU32	(J)V
    //   29: aload_0
    //   30: iconst_3
    //   31: aload_0
    //   32: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   35: invokevirtual 92	com/tencent/mm/d:setVar	(ILandroid/renderscript/FieldPacker;)V
    //   38: aload_0
    //   39: lconst_0
    //   40: putfield 94	com/tencent/mm/d:cPZ	J
    //   43: ldc 77
    //   45: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: new 81	android/renderscript/FieldPacker
    //   55: dup
    //   56: iconst_4
    //   57: invokespecial 96	android/renderscript/FieldPacker:<init>	(I)V
    //   60: putfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   63: goto -42 -> 21
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	d
    //   66	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	66	finally
    //   21	48	66	finally
    //   51	63	66	finally
  }
  
  public final void a(Allocation paramAllocation)
  {
    try
    {
      AppMethodBeat.i(93337);
      setVar(0, paramAllocation);
      this.cPW = paramAllocation;
      AppMethodBeat.o(93337);
      return;
    }
    finally
    {
      paramAllocation = finally;
      throw paramAllocation;
    }
  }
  
  public final void a(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    AppMethodBeat.i(93347);
    if (!paramAllocation1.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93347);
      throw paramAllocation1;
    }
    if (!paramAllocation2.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93347);
      throw paramAllocation1;
    }
    Type localType1 = paramAllocation1.getType();
    Type localType2 = paramAllocation2.getType();
    if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps()))
    {
      paramAllocation1 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
      AppMethodBeat.o(93347);
      throw paramAllocation1;
    }
    forEach(1, paramAllocation1, paramAllocation2, null, null);
    AppMethodBeat.o(93347);
  }
  
  /* Error */
  public final void aW(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 157
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   11: ifnull +40 -> 51
    //   14: aload_0
    //   15: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   18: invokevirtual 84	android/renderscript/FieldPacker:reset	()V
    //   21: aload_0
    //   22: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   25: lload_1
    //   26: invokevirtual 88	android/renderscript/FieldPacker:addU32	(J)V
    //   29: aload_0
    //   30: iconst_4
    //   31: aload_0
    //   32: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   35: invokevirtual 92	com/tencent/mm/d:setVar	(ILandroid/renderscript/FieldPacker;)V
    //   38: aload_0
    //   39: lload_1
    //   40: putfield 159	com/tencent/mm/d:cQa	J
    //   43: ldc 157
    //   45: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: new 81	android/renderscript/FieldPacker
    //   55: dup
    //   56: iconst_4
    //   57: invokespecial 96	android/renderscript/FieldPacker:<init>	(I)V
    //   60: putfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   63: goto -42 -> 21
    //   66: astore_3
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_3
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	d
    //   0	71	1	paramLong	long
    //   66	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	66	finally
    //   21	48	66	finally
    //   51	63	66	finally
  }
  
  /* Error */
  public final void aX(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 161
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   11: ifnull +40 -> 51
    //   14: aload_0
    //   15: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   18: invokevirtual 84	android/renderscript/FieldPacker:reset	()V
    //   21: aload_0
    //   22: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   25: lload_1
    //   26: invokevirtual 88	android/renderscript/FieldPacker:addU32	(J)V
    //   29: aload_0
    //   30: iconst_5
    //   31: aload_0
    //   32: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   35: invokevirtual 92	com/tencent/mm/d:setVar	(ILandroid/renderscript/FieldPacker;)V
    //   38: aload_0
    //   39: lload_1
    //   40: putfield 163	com/tencent/mm/d:cQb	J
    //   43: ldc 161
    //   45: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: new 81	android/renderscript/FieldPacker
    //   55: dup
    //   56: iconst_4
    //   57: invokespecial 96	android/renderscript/FieldPacker:<init>	(I)V
    //   60: putfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   63: goto -42 -> 21
    //   66: astore_3
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_3
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	d
    //   0	71	1	paramLong	long
    //   66	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	66	finally
    //   21	48	66	finally
    //   51	63	66	finally
  }
  
  /* Error */
  public final void aY(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 165
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   11: ifnull +41 -> 52
    //   14: aload_0
    //   15: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   18: invokevirtual 84	android/renderscript/FieldPacker:reset	()V
    //   21: aload_0
    //   22: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   25: lload_1
    //   26: invokevirtual 88	android/renderscript/FieldPacker:addU32	(J)V
    //   29: aload_0
    //   30: bipush 6
    //   32: aload_0
    //   33: getfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   36: invokevirtual 92	com/tencent/mm/d:setVar	(ILandroid/renderscript/FieldPacker;)V
    //   39: aload_0
    //   40: lload_1
    //   41: putfield 167	com/tencent/mm/d:cQc	J
    //   44: ldc 165
    //   46: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: new 81	android/renderscript/FieldPacker
    //   56: dup
    //   57: iconst_4
    //   58: invokespecial 96	android/renderscript/FieldPacker:<init>	(I)V
    //   61: putfield 79	com/tencent/mm/d:cPV	Landroid/renderscript/FieldPacker;
    //   64: goto -43 -> 21
    //   67: astore_3
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_3
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	d
    //   0	72	1	paramLong	long
    //   67	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	67	finally
    //   21	49	67	finally
    //   52	64	67	finally
  }
  
  public final void b(Allocation paramAllocation)
  {
    try
    {
      AppMethodBeat.i(93344);
      setVar(8, paramAllocation);
      this.cQd = paramAllocation;
      AppMethodBeat.o(93344);
      return;
    }
    finally
    {
      paramAllocation = finally;
      throw paramAllocation;
    }
  }
  
  public final void b(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    AppMethodBeat.i(93348);
    if (!paramAllocation1.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93348);
      throw paramAllocation1;
    }
    if (!paramAllocation2.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93348);
      throw paramAllocation1;
    }
    Type localType1 = paramAllocation1.getType();
    Type localType2 = paramAllocation2.getType();
    if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps()))
    {
      paramAllocation1 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
      AppMethodBeat.o(93348);
      throw paramAllocation1;
    }
    forEach(3, paramAllocation1, paramAllocation2, null, null);
    AppMethodBeat.o(93348);
  }
  
  public final void c(Allocation paramAllocation)
  {
    try
    {
      AppMethodBeat.i(93345);
      setVar(9, paramAllocation);
      this.cQe = paramAllocation;
      AppMethodBeat.o(93345);
      return;
    }
    finally
    {
      paramAllocation = finally;
      throw paramAllocation;
    }
  }
  
  public final void c(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    AppMethodBeat.i(93349);
    if (!paramAllocation1.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93349);
      throw paramAllocation1;
    }
    if (!paramAllocation2.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93349);
      throw paramAllocation1;
    }
    Type localType1 = paramAllocation1.getType();
    Type localType2 = paramAllocation2.getType();
    if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps()))
    {
      paramAllocation1 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
      AppMethodBeat.o(93349);
      throw paramAllocation1;
    }
    forEach(4, paramAllocation1, paramAllocation2, null, null);
    AppMethodBeat.o(93349);
  }
  
  public final void d(Allocation paramAllocation)
  {
    try
    {
      AppMethodBeat.i(93346);
      setVar(10, paramAllocation);
      this.cQf = paramAllocation;
      AppMethodBeat.o(93346);
      return;
    }
    finally
    {
      paramAllocation = finally;
      throw paramAllocation;
    }
  }
  
  public final void d(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    AppMethodBeat.i(93350);
    if (!paramAllocation1.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93350);
      throw paramAllocation1;
    }
    if (!paramAllocation2.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation1 = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93350);
      throw paramAllocation1;
    }
    Type localType1 = paramAllocation1.getType();
    Type localType2 = paramAllocation2.getType();
    if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps()))
    {
      paramAllocation1 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
      AppMethodBeat.o(93350);
      throw paramAllocation1;
    }
    forEach(5, paramAllocation1, paramAllocation2, null, null);
    AppMethodBeat.o(93350);
  }
  
  public final void e(Allocation paramAllocation)
  {
    AppMethodBeat.i(93351);
    if (!paramAllocation.getType().getElement().isCompatible(this.cPU))
    {
      paramAllocation = new RSRuntimeException("Type mismatch with U8_4!");
      AppMethodBeat.o(93351);
      throw paramAllocation;
    }
    forEach(7, null, paramAllocation, null, null);
    AppMethodBeat.o(93351);
  }
  
  public final void hg(int paramInt)
  {
    try
    {
      AppMethodBeat.i(93338);
      setVar(1, paramInt);
      this.cPX = paramInt;
      AppMethodBeat.o(93338);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void hh(int paramInt)
  {
    try
    {
      AppMethodBeat.i(93339);
      setVar(2, paramInt);
      this.cPY = paramInt;
      AppMethodBeat.o(93339);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d
 * JD-Core Version:    0.7.0.1
 */