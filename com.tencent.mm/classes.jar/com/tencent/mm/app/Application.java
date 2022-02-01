package com.tencent.mm.app;

import com.tencent.tinker.loader.app.TinkerApplication;

public class Application
  extends TinkerApplication
{
  private static final String TINKER_LOADER_ENTRY_CLASSNAME = "com.tencent.tinker.loader.TinkerLoader";
  private static final String WECHAT_APPLICATION_LIKE_CLASSNAME = "com.tencent.mm.app.MMApplicationLike";
  
  public Application()
  {
    super(7, "com.tencent.mm.app.MMApplicationLike", "com.tencent.tinker.loader.TinkerLoader", true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.Application
 * JD-Core Version:    0.7.0.1
 */