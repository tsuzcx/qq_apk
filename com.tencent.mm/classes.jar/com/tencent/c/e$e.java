package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
import java.util.Map;

public abstract class e$e
{
  public static void a(BinaryMessenger paramBinaryMessenger, e parame)
  {
    BasicMessageChannel localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterMMKVHost.getString", new StandardMessageCodec());
    if (parame != null)
    {
      localBasicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler()
      {
        public final void onMessage(Object paramAnonymousObject, BasicMessageChannel.Reply<Object> paramAnonymousReply)
        {
          AppMethodBeat.i(229119);
          HashMap localHashMap1 = new HashMap();
          try
          {
            paramAnonymousObject = e.f.db((Map)paramAnonymousObject);
            paramAnonymousObject = this.ahhG.a(paramAnonymousObject);
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("value", paramAnonymousObject.value);
            localHashMap1.put("result", localHashMap2);
            paramAnonymousReply.reply(localHashMap1);
            AppMethodBeat.o(229119);
            return;
          }
          catch (RuntimeException paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap1.put("error", e.C(paramAnonymousObject));
            }
          }
          catch (Error paramAnonymousObject)
          {
            label78:
            break label78;
          }
        }
      });
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterMMKVHost.putString", new StandardMessageCodec());
      if (parame == null) {
        break label213;
      }
      localBasicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler()
      {
        public final void onMessage(Object paramAnonymousObject, BasicMessageChannel.Reply<Object> paramAnonymousReply)
        {
          AppMethodBeat.i(229118);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = e.f.db((Map)paramAnonymousObject);
            this.ahhG.b(paramAnonymousObject);
            localHashMap.put("result", null);
            paramAnonymousReply.reply(localHashMap);
            AppMethodBeat.o(229118);
            return;
          }
          catch (RuntimeException paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", e.C(paramAnonymousObject));
            }
          }
          catch (Error paramAnonymousObject)
          {
            label53:
            break label53;
          }
        }
      });
      label68:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterMMKVHost.getBool", new StandardMessageCodec());
      if (parame == null) {
        break label221;
      }
      localBasicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler()
      {
        public final void onMessage(Object paramAnonymousObject, BasicMessageChannel.Reply<Object> paramAnonymousReply)
        {
          AppMethodBeat.i(229115);
          HashMap localHashMap1 = new HashMap();
          try
          {
            paramAnonymousObject = e.a.cZ((Map)paramAnonymousObject);
            paramAnonymousObject = this.ahhG.a(paramAnonymousObject);
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("value", paramAnonymousObject.ahhE);
            localHashMap1.put("result", localHashMap2);
            paramAnonymousReply.reply(localHashMap1);
            AppMethodBeat.o(229115);
            return;
          }
          catch (RuntimeException paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap1.put("error", e.C(paramAnonymousObject));
            }
          }
          catch (Error paramAnonymousObject)
          {
            label78:
            break label78;
          }
        }
      });
      label102:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterMMKVHost.putBool", new StandardMessageCodec());
      if (parame == null) {
        break label229;
      }
      localBasicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler()
      {
        public final void onMessage(Object paramAnonymousObject, BasicMessageChannel.Reply<Object> paramAnonymousReply)
        {
          AppMethodBeat.i(229117);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = e.a.cZ((Map)paramAnonymousObject);
            this.ahhG.b(paramAnonymousObject);
            localHashMap.put("result", null);
            paramAnonymousReply.reply(localHashMap);
            AppMethodBeat.o(229117);
            return;
          }
          catch (RuntimeException paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", e.C(paramAnonymousObject));
            }
          }
          catch (Error paramAnonymousObject)
          {
            label53:
            break label53;
          }
        }
      });
      label136:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterMMKVHost.getInt", new StandardMessageCodec());
      if (parame == null) {
        break label237;
      }
      localBasicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler()
      {
        public final void onMessage(Object paramAnonymousObject, BasicMessageChannel.Reply<Object> paramAnonymousReply)
        {
          AppMethodBeat.i(229127);
          HashMap localHashMap1 = new HashMap();
          try
          {
            paramAnonymousObject = e.c.da((Map)paramAnonymousObject);
            paramAnonymousObject = this.ahhG.a(paramAnonymousObject);
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("value", paramAnonymousObject.ahhF);
            localHashMap1.put("result", localHashMap2);
            paramAnonymousReply.reply(localHashMap1);
            AppMethodBeat.o(229127);
            return;
          }
          catch (RuntimeException paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap1.put("error", e.C(paramAnonymousObject));
            }
          }
          catch (Error paramAnonymousObject)
          {
            label78:
            break label78;
          }
        }
      });
    }
    for (;;)
    {
      paramBinaryMessenger = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterMMKVHost.putInt", new StandardMessageCodec());
      if (parame == null) {
        break label245;
      }
      paramBinaryMessenger.setMessageHandler(new BasicMessageChannel.MessageHandler()
      {
        public final void onMessage(Object paramAnonymousObject, BasicMessageChannel.Reply<Object> paramAnonymousReply)
        {
          AppMethodBeat.i(229133);
          HashMap localHashMap = new HashMap();
          try
          {
            paramAnonymousObject = e.c.da((Map)paramAnonymousObject);
            this.ahhG.b(paramAnonymousObject);
            localHashMap.put("result", null);
            paramAnonymousReply.reply(localHashMap);
            AppMethodBeat.o(229133);
            return;
          }
          catch (RuntimeException paramAnonymousObject)
          {
            for (;;)
            {
              localHashMap.put("error", e.C(paramAnonymousObject));
            }
          }
          catch (Error paramAnonymousObject)
          {
            label53:
            break label53;
          }
        }
      });
      return;
      localBasicMessageChannel.setMessageHandler(null);
      break;
      label213:
      localBasicMessageChannel.setMessageHandler(null);
      break label68;
      label221:
      localBasicMessageChannel.setMessageHandler(null);
      break label102;
      label229:
      localBasicMessageChannel.setMessageHandler(null);
      break label136;
      label237:
      localBasicMessageChannel.setMessageHandler(null);
    }
    label245:
    paramBinaryMessenger.setMessageHandler(null);
  }
  
  public abstract e.b a(e.a parama);
  
  public abstract e.d a(e.c paramc);
  
  public abstract e.g a(e.f paramf);
  
  public abstract void b(e.a parama);
  
  public abstract void b(e.c paramc);
  
  public abstract void b(e.f paramf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.e.e
 * JD-Core Version:    0.7.0.1
 */