package com.tencent.magicbrush.handler.a;

import java.util.LinkedList;
import java.util.Queue;

final class g$a
{
  Queue<k> bkY = new LinkedList();
  
  final k qM()
  {
    k localk2 = (k)this.bkY.poll();
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = new k();
    }
    return localk1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.g.a
 * JD-Core Version:    0.7.0.1
 */