package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AsyncTask$d
{
  static
  {
    AppMethodBeat.i(98176);
    a = new d("PENDING", 0);
    b = new d("RUNNING", 1);
    c = new d("FINISHED", 2);
    d = new d[] { a, b, c };
    AppMethodBeat.o(98176);
  }
  
  private AsyncTask$d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.d
 * JD-Core Version:    0.7.0.1
 */