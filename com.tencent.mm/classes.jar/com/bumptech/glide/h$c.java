package com.bumptech.glide;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h$c
  extends h.a
{
  public h$c(Class<?> paramClass1, Class<?> paramClass2)
  {
    super("Failed to find any ModelLoaders for model: " + paramClass1 + " and data: " + paramClass2);
    AppMethodBeat.i(76791);
    AppMethodBeat.o(76791);
  }
  
  public h$c(Object paramObject)
  {
    super("Failed to find any ModelLoaders for model: ".concat(String.valueOf(paramObject)));
    AppMethodBeat.i(76790);
    AppMethodBeat.o(76790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.bumptech.glide.h.c
 * JD-Core Version:    0.7.0.1
 */