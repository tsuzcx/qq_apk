package com.eclipsesource.v8;

import java.io.File;

class NodeJS$2
  implements JavaCallback
{
  NodeJS$2(NodeJS paramNodeJS, File paramFile) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    paramV8Object = new V8Array(NodeJS.access$100(this.this$0));
    try
    {
      paramV8Object.push(this.val$file.getAbsolutePath());
      paramV8Array = NodeJS.access$200(this.this$0).call(null, paramV8Object);
      return paramV8Array;
    }
    finally
    {
      paramV8Object.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.NodeJS.2
 * JD-Core Version:    0.7.0.1
 */