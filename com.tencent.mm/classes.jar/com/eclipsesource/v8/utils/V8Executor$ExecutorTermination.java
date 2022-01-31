package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

class V8Executor$ExecutorTermination
  implements JavaVoidCallback
{
  V8Executor$ExecutorTermination(V8Executor paramV8Executor) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if (V8Executor.access$000(this.this$0)) {
      throw new RuntimeException("V8Thread Termination");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8Executor.ExecutorTermination
 * JD-Core Version:    0.7.0.1
 */